package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        IntIncrementor.run(Console.readInt("Input count:"), Console.readInt("Input number of threads:"));
        System.out.printf("Value1:%d%n", IntIncrementor.getValue1());
        System.out.printf("Value2:%d%n", IntIncrementor.getValue2());
    }
}


