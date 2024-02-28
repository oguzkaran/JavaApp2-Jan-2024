package org.csystem.app.imageprocessing;

import com.karandev.io.util.console.Console;
import org.csystem.app.imageprocessing.server.Server;

import static com.karandev.io.util.console.commandline.CommandLineUtil.*;

import java.io.IOException;

class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "wrong number of arguments!..");

            var port = Integer.parseInt(args[0]);
            var backlog = Integer.parseInt(args[1]);
            var server = new Server(port, backlog);

            server.run();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO exception occurred:%s", ex.getMessage());
        }
    }
}
