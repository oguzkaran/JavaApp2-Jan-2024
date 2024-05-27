package org.csystem.app.process.runner;


import com.karandev.io.util.console.Console;

import java.util.Random;
import java.util.stream.IntStream;

class Application {
    public static void run(String[] args)
    {
        var random = new Random();

        IntStream.generate(() -> random.nextInt(100)).limit(10).mapToObj("Output:%d"::formatted).forEach(Console::writeLine);
        IntStream.generate(() -> random.nextInt(100)).limit(10).mapToObj("Error:%d"::formatted).forEach(Console.Error::writeLine);

        throw new RuntimeException();
    }
}
