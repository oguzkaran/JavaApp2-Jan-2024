package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.concurrent.TimeUnit;

class Application {
    public static void run(String[] args)
    {
        var clock = new DigitalClock(Console.readInt("Input timeout value in seconds:"), TimeUnit.SECONDS);

        clock.run();
    }
}


