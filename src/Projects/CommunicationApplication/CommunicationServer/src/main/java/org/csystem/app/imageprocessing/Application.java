package org.csystem.app.imageprocessing;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.commandprompt.CommandPrompt;
import com.karandev.util.net.IpUtil;
import org.csystem.app.imageprocessing.server.InformationServer;
import org.csystem.app.imageprocessing.server.manage.ManageServerCommands;

import java.io.IOException;
import java.util.concurrent.Executors;

import static com.karandev.io.util.console.commandline.CommandLineUtil.checkLengthLessOrEquals;

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
            checkLengthLessOrEquals(args.length, 2, "wrong number of arguments!...");
            int basePort = 0;
            int backlog = 512;

            if (args.length == 1) {
                backlog = Integer.parseInt(args[0]);
                basePort = findAvailablePorts();
            }
            else if (args.length == 2) {
                backlog = Integer.parseInt(args[0]);
                basePort = Integer.parseInt(args[1]);
            }
            else
                basePort = findAvailablePorts();

            var grayscaleServer = new InformationServer(basePort, backlog);

            new CommandPrompt.Builder()
                    .setPrompt("manager")
                    .register(new ManageServerCommands(grayscaleServer, Executors.newCachedThreadPool()))
                    .build().run();

        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Exception occurred:%s", ex.getMessage());
        }
    }
}
