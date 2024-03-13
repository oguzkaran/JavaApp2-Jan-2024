package org.csystem.app.imageprocessing;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.commandprompt.CommandPrompt;
import org.csystem.app.imageprocessing.client.CommandsInfo;

import static com.karandev.io.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "wrong number of arguments!...");
            new CommandPrompt.Builder()
                    .register(new CommandsInfo(args[0], Integer.parseInt(args[1])))
                    .setPrompt("csd")
                    .setSuffix("$")
                    .build()
                    .run();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments!....");
        }
    }
}
