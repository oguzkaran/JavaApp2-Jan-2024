package org.csystem.app;

import com.karandev.io.util.console.Console;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

class Application {
    private static void receive(int port, int size)
    {
        var buf = new byte[size];

        try (var datagramSocket = new DatagramSocket(port)) {
            var datagramPacket = new DatagramPacket(buf, buf.length);

            datagramSocket.receive(datagramPacket);

            var str = new String(datagramPacket.getData(), 0, datagramPacket.getLength(), StandardCharsets.UTF_8);

            Console.writeLine(str);

        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Problem occurred:%s", ex.getMessage());
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "wrong number of arguments");

        try {
            while (true)
                receive(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid port number!...");
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Problem occurred:%s", ex.getMessage());
        }
    }
}
