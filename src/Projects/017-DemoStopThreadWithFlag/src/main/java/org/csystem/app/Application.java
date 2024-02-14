
/*
    x = a + b + 10;
    y = a + b + 20;
    z = a + b + 30;

    reg = a + b;
    x = reg + 10;
    y = reg + 20;
    z = reg + 30;
*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.concurrent.ThreadUtil;

import java.util.concurrent.TimeUnit;

class Application {
    private static boolean ms_flag = true;

    private static void threadCallback()
    {
        var a = 0L;

        while (ms_flag)
            Console.writeLine(a++);
    }

    public static void run(String[] args)
    {
        var t = new Thread(Application::threadCallback);

        t.start();

        ThreadUtil.sleep(3, TimeUnit.SECONDS);
        ms_flag = false;
    }
}

