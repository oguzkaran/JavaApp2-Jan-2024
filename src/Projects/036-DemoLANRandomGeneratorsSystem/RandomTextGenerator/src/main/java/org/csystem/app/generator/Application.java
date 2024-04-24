package org.csystem.app.generator;

import com.karandev.io.util.console.Console;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;
import static org.csystem.app.generator.global.ServerUtil.*;

class Application {
    private static void removeInactivesSchedulerCallback()
    {
        synchronized (SYNC_LOCK) {
            SERVERS = SERVERS.stream().filter(ServerInfo::isActive).collect(Collectors.toSet());
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "wrong number of arguments");

        try {
            var threadPool = Executors.newScheduledThreadPool(2);

            var serverReceiver = new ServerReceiver(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            var textGenerator = new TextGenerator();

            THREAD_POOL.execute(serverReceiver::run);
            threadPool.scheduleAtFixedRate(textGenerator::run, 0, 500, TimeUnit.MILLISECONDS);
            threadPool.scheduleAtFixedRate(Application::removeInactivesSchedulerCallback, 0, 100, TimeUnit.MILLISECONDS);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid port values!...");
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
        }
    }
}
