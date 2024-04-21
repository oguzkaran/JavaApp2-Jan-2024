package org.csystem.app;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.UdpUtil;
import com.karandev.util.net.exception.NetworkException;
import org.w3c.dom.CDATASection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

class Application {
    private static void receive(DatagramSocket datagramSocket, int size)
    {
        try {
            var str = UdpUtil.receiveString(datagramSocket, size);

            Console.writeLine(str);
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("IO Problem occurred:%s", ex.getMessage());
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "wrong number of arguments");

        try {
            try (var datagramSocket = new DatagramSocket(Integer.parseInt(args[0]))) {
                while (true)
                    receive(datagramSocket, Integer.parseInt(args[1]));
            }
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid port number!...");
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Problem occurred:%s", ex.getMessage());
        }
    }
}
