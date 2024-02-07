package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.app.thread.RandomTextGeneratorThread;

class Application {
    public static void run(String[] args)
    {
        var self = Thread.currentThread();

        var nThreads = Console.readInt("Input number of threads:");
        var count = Console.readInt("Input count:");

        System.out.printf("Name:%s%n", self.getName());

        for (var i = 0; i < nThreads; ++i) {
            var thread = new RandomTextGeneratorThread("Generator-" + (i + 1), count, 5, 15);

            thread.start();
        }

        System.out.println("main ends!...");
    }
}
