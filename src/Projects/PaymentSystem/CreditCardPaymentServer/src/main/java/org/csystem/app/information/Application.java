package org.csystem.app.information;

import com.karandev.io.util.console.Console;
import org.csystem.app.information.client.InformationClient;

import java.io.IOException;
import java.util.concurrent.Executors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 4, "usage: ... <id> <host> <manager port> <base port>");
            var id = Integer.parseInt(args[0]);
            var host = args[1];
            var managerPort = Integer.parseInt(args[2]);
            var basePort = Integer.parseInt(args[3]);
            var informationClient = new InformationClient(basePort);

            informationClient.run(id, host, managerPort);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Exception occurred:%s", ex.getMessage());
        }
    }
}
