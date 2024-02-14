package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.ArrayList;
import java.util.Random;

class Application {
    public static void run(String[] args)
    {
        var stringGenerator = new StringGenerator(new ArrayList<>(),  Console.readInt("Input min:"),
                Console.readInt("Input bound:"), Console.readInt("Input count:"), new Random());

        stringGenerator.run();
        System.out.printf("Size:%d%n", stringGenerator.size());
    }
}


