package org.csystem.app.generator;

import com.karandev.io.util.console.Console;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

class Application {

    public static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "wrong number of arguments");

        try {
            var threadPool = Executors.newScheduledThreadPool(2);

            var serverReceiver = new ServerReceiver(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            var textGenerator = new TextGenerator();

            threadPool.execute(serverReceiver::run);
            threadPool.scheduleAtFixedRate(textGenerator::run, 0, 500, TimeUnit.MILLISECONDS);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid port values!...");
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
        }
    }
}
