package org.csystem.app.imageprocessing;

import com.karandev.io.util.console.CommandPrompt;
import com.karandev.io.util.console.Console;
import com.karandev.util.net.IpUtil;
import org.csystem.app.imageprocessing.server.ImageProcessingServer;
import org.csystem.app.imageprocessing.server.manage.ManageServerCommands;

import java.io.IOException;
import java.util.concurrent.Executors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthLessOrEqual;

class Application {
    private static int findAvailablePorts() throws IOException
    {
        var opt = IpUtil.getFirstAvailablePort(1024, 65536);

        if (opt.isEmpty())
            throw new IOException("No available port!...");

        var basePort = opt.getAsInt();
        opt = IpUtil.getFirstAvailablePort(basePort + 1);

        if (opt.isEmpty())
            throw new IOException("No available port!...");

        return basePort;
    }

    public static void run(String[] args)
    {
        try {
            checkLengthLessOrEqual(args.length, 2, "wrong number of arguments!...");
            int port;
            var backlog = 512;

            if (args.length == 1) {
                backlog = Integer.parseInt(args[0]);
                port = findAvailablePorts();
            }
            else if (args.length == 2) {
                backlog = Integer.parseInt(args[0]);
                port = Integer.parseInt(args[1]);
            }
            else
                port = findAvailablePorts();

            var grayscaleServer = new ImageProcessingServer(port, backlog);

            CommandPrompt.createBuilder()
                    .setPrompt("image-processing-server")
                    .registerObject(new ManageServerCommands(grayscaleServer, Executors.newCachedThreadPool()))
                    .create().run();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Exception occurred:%s", ex.getMessage());
        }
    }
}
