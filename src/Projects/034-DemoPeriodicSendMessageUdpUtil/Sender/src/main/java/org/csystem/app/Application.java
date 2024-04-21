package org.csystem.app;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.UdpUtil;
import com.karandev.util.net.exception.NetworkException;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

class Application {
    private static void sendText(String host, int port, String text)
    {
        try (var datagramSocket = new DatagramSocket()) {
            text = "%s-%s".formatted(text, DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));

            UdpUtil.sendString(datagramSocket, host, port, text);
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("Network problem occurred:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Problem occurred:%s", ex.getMessage());
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 4, "wrong number of arguments!...");

        ScheduledExecutorService scheduledExecutorService = null;

        try {
            scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.scheduleAtFixedRate(() -> sendText(args[0], Integer.parseInt(args[1]), args[3]), 0,
                        Integer.parseInt(args[2]), TimeUnit.MILLISECONDS);
            
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid port number!...");
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Internal problem occurred:%s", ex.getMessage());
        }
    }
}
