package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.Random;

class Application {
    public static void run(String[] args)
    {
        var stringGenerator = new StringGenerator(Console.readInt("Input count:"), new Random());

        stringGenerator.run(Console.readInt("Input number of threads:"));
        System.out.printf("Size:%d%n", stringGenerator.size());
    }
}


