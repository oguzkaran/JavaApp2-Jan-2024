package org.csystem.app.imageprocessing;

import com.karandev.io.util.console.Console;
import org.csystem.app.imageprocessing.server.BinaryImageServer;
import org.csystem.app.imageprocessing.server.GrayscaleImageServer;

import java.io.IOException;

import static com.karandev.io.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "wrong number of arguments!..");

            var port = Integer.parseInt(args[0]);
            var backlog = Integer.parseInt(args[1]);
            new GrayscaleImageServer(port, backlog).run();
            new BinaryImageServer(port + 1, backlog).run();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Exception occurred:%s", ex.getMessage());
        }
    }
}
