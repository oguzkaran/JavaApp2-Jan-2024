package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.concurrent.ThreadUtil;

import java.util.Random;

class Application {
    private static void threadCallback1()
    {
        var random = new Random();

        while (true) {
            var val = random.nextInt(-100, 100);

            if (val < 0)
                throw new NumberFormatException("Invalid number generated!...");

            Console.writeLine("Thread-1:%d", val);

            ThreadUtil.sleep(1000);
        }
    }

    private static void threadCallback2()
    {
        var random = new Random();

        while (true) {
            var val = random.nextInt(-100, 100);

            Console.writeLine("Thread-2:%d", val);

            ThreadUtil.sleep(1000);
        }
    }

    public static void run(String[] args)
    {
        var t1 = new Thread(Application::threadCallback1);
        var t2 = new Thread(Application::threadCallback2);

        t1.start();
        t2.start();
    }
}

