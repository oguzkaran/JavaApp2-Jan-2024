package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        var incrementer = new IntIncrementor(Console.readInt("Input count:"));

        incrementer.run(Console.readInt("Input number of threads:"));
        System.out.printf("Value:%d%n", incrementer.getValue());
    }
}


