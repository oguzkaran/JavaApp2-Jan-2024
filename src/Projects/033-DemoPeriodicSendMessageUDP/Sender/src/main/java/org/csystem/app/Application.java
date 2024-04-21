package org.csystem.app;

import com.karandev.io.util.console.Console;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

class Application {
    private static void sendText(String host, int port, String text)
    {
        try (var datagramSocket = new DatagramSocket()) {
            var data = text.getBytes(StandardCharsets.UTF_8);

            var datagramPacket = new DatagramPacket(data, data.length, InetAddress.getByName(host), port);

            datagramSocket.send(datagramPacket);
        }
        catch (UnknownHostException ex) {
            Console.Error.writeLine("Unknown host:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.Error.writeLine("Problem occurred:%s", ex.getMessage());
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 2, "wrong number of arguments!...");

        try {
            while (true) {
                var str = Console.read("Input text:");

                if ("quit".equals(str))
                    break;

                sendText(args[0], Integer.parseInt(args[1]), str);
            }
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid port number!...");
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Internal problem occurred:%s", ex.getMessage());
        }
    }
}
