package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.Random;

import static java.lang.Integer.parseInt;

class Application {
    private static void join(Thread thread)
    {
        try {
            thread.join();
        }
        catch (InterruptedException ignore) {

        }
    }

    private static void generateAndFindTotalThreadCallback(ThreadParam param)
    {
        var self = Thread.currentThread();
        var random = new Random();
        var count = param.getCount();
        var min = param.getMin();
        var bound = param.getBound();

        for (var i = 0; i < count; ++i) {
            var val = random.nextInt(min, bound);

            //Console.writeLine("%s:%d", self.getName(), val);
            param.add(val);
        }
    }

    public static void run(String[] args)
    {
        if (args.length != 4) {
            Console.Error.writeLine("Wrong number of arguments!...");
            System.exit(1);
        }

        try {
            var nThreads = Integer.parseInt(args[0]);
            var threads = new Thread[nThreads];
            var threadParams = new ThreadParam[nThreads];

            for (var i = 0; i < nThreads; ++i) {
                int idx = i;

                threadParams[idx] = new ThreadParam(parseInt(args[1]), parseInt(args[2]), parseInt(args[3]));
                threads[i] =new Thread(() -> generateAndFindTotalThreadCallback(threadParams[idx]), "Thread-" + (i + 1));
                threads[i].start();
            }

            for (var t : threads)
                join(t);

            for (var tp : threadParams)
                Console.writeLine("Result:%d", tp.getResult());
        }
        catch (NumberFormatException ignore) {
            Console.writeLine("Invalid arguments!...");
        }
    }
}

