package org.csystem.app.communication.client;

import com.karandev.io.util.console.CommandPrompt;
import com.karandev.io.util.console.Console;


import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "wrong number of arguments!...");
            CommandPrompt.createBuilder()
                    .registerObject(new CommandsInfo(args[0], Integer.parseInt(args[1])))
                    .setPrompt("csd")
                    .setSuffix("$")
                    .create()
                    .run();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments!....");
        }
    }
}
