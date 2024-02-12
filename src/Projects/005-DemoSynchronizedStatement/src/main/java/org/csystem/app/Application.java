package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        var incrementer = new IntIncrementor(Console.readInt("Input count:"));

        incrementer.run(Console.readInt("Input number of threads:"));
        System.out.printf("Value1:%d%n", incrementer.getValue1());
        System.out.printf("Value2:%d%n", incrementer.getValue2());
    }
}


