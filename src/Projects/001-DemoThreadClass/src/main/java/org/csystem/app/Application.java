package org.csystem.app;


import org.csystem.app.thread.RandomTextGeneratorThread;

class Application {
    public static void run(String[] args)
    {
        var self = Thread.currentThread();

        System.out.printf("Name:%s%n", self.getName());

        for (var i = 0; i < 10; ++i) {
            var thread = new RandomTextGeneratorThread("Generator-" + (i + 1), 100000, 5, 15);

            thread.start();
        }

        System.out.println("main ends!...");
    }
}
