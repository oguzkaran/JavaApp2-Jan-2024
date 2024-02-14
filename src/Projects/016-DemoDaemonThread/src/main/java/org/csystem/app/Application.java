package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.Random;

class Application {
    private static void threadCallback()
    {
        var random = new Random();
        var self = Thread.currentThread();

        Console.writeLine("%s Thread is %s", self.getName(), self.isDaemon() ? "daemon" : "non-daemon");

        for (var i = 0; i < 10; ++i)
            Console.write("%d ", i * 10);

        Console.writeLine();
        var t = new Thread(Application::threadCallback);

        t.setDaemon(random.nextBoolean());
        t.start();
    }

    public static void run(String[] args)
    {
        var random = new Random();
        var self = Thread.currentThread();

        Console.writeLine("%s Thread is %s", self.getName(), self.isDaemon() ? "daemon" : "non-daemon");
        var t = new Thread(Application::threadCallback);

        t.setDaemon(random.nextBoolean());
        t.start();
        Console.writeLine("main ends");
    }
}


