package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.app.generator.ServerReceiver;

import java.util.concurrent.Executors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

class Application {

    public static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "wrong number of arguments");

        try {
            var threadPool = Executors.newScheduledThreadPool(2);

            var serverReceiver = new ServerReceiver(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

            threadPool.execute(serverReceiver::run);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid port values!...");
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
        }
    }
}
