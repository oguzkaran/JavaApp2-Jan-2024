package org.csystem.app.imageprocessing;

import com.karandev.io.util.console.CommandPrompt;
import com.karandev.io.util.console.Console;
import org.csystem.app.imageprocessing.server.BinaryImageServer;
import org.csystem.app.imageprocessing.server.GrayscaleImageServer;
import org.csystem.app.imageprocessing.server.manage.ManageServerCommands;

import java.io.IOException;
import java.util.concurrent.Executors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "wrong number of arguments!..");

            var port = Integer.parseInt(args[0]);
            var backlog = Integer.parseInt(args[1]);
            var grayscaleServer = new GrayscaleImageServer(port, backlog);
            var binaryServer = new BinaryImageServer(port + 1, backlog);

            CommandPrompt.createBuilder()
                    .setPrompt("server")
                    .registerObject(new ManageServerCommands(grayscaleServer, binaryServer, Executors.newCachedThreadPool()))
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
