package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.concurrent.ThreadUtil;

import java.util.concurrent.TimeUnit;

class Application {
    private static void threadCallback1()
    {
        var a = 0L;
        var self = Thread.currentThread();

        while (!self.isInterrupted())
            Console.writeLine("t1->First:%d", a++);

        while (!self.isInterrupted())
            Console.writeLine("t1->Second:%d", a++);
    }

    private static void threadCallback2()
    {
        var a = 0L;

        while (!Thread.interrupted())
            Console.writeLine("t2->First:%d", a++);

        while (!Thread.interrupted())
            Console.writeLine("t2->Second:%d", a++);
    }

    public static void run(String[] args)
    {
        var t1 = new Thread(Application::threadCallback1);
        var t2 = new Thread(Application::threadCallback2);

        t1.start();
        t2.start();

        ThreadUtil.sleep(3, TimeUnit.SECONDS);
        t1.interrupt();
        t2.interrupt();
        ThreadUtil.sleep(3, TimeUnit.SECONDS);
        t2.interrupt();
    }
}

