package org.csystem.app.generator.server;

import com.karandev.io.util.console.Console;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

class Application {

    public static void run(String[] args)
    {
        checkLengthEquals(4, args.length, "wrong number of arguments");

        try {
            var address = "%s.255".formatted(args[0]);
            var generatorPort = Integer.parseInt(args[1]);
            var port = Integer.parseInt(args[2]);
            var tryCount = Integer.parseInt(args[3]);

            new InfoClient(address, generatorPort, port, tryCount).run();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid port values!...");
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
        }
    }
}
