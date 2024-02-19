package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.concurrent.ThreadUtil;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Application {
    private static void threadCallback1()
    {
        var random = new Random();
        var a = 0L;

        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(500, 1001));
                Console.writeLine("thread-1:%d", a++);
            }
        }
        catch (InterruptedException ignore) {
            Console.writeLine("thread-1 ends!...");
        }
    }

    private static void threadCallback2()
    {
        var random = new Random();
        var a = 0L;

        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(500, 1001));
                Console.writeLine("thread-2:%d", a++);
            }
            catch (InterruptedException ignore) {
                Console.writeLine("interrupt!...");
            }
        }
    }

    public static void run(String[] args)
    {
        var t1 = new Thread(Application::threadCallback1);
        var t2 = new Thread(Application::threadCallback2);

        t1.start();
        t2.start();

        ThreadUtil.sleep(5, TimeUnit.SECONDS);
        t1.interrupt();
        t2.interrupt();
        ThreadUtil.sleep(5, TimeUnit.SECONDS);
        t2.interrupt();
    }
}

