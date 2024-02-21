package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Integer.parseInt;

class Application {
    private static void join(Future<?> future)
    {
        try {
            future.get();
        }
        catch (ExecutionException | InterruptedException ignore) {

        }
    }

    private static void doCalculate(int nThreads, int count, int min, int bound)
    {
            var threadPool = Executors.newFixedThreadPool(nThreads);
            var futures = new Future<?>[nThreads];
            var threadParams = new ThreadParam[nThreads];

            for (var i = 0; i < nThreads; ++i) {
                int idx = i;

                threadParams[idx] = new ThreadParam(count, min, bound);
                futures[i] = threadPool.submit(() -> generateAndFindTotalThreadCallback(threadParams[idx]));
            }

            for (var future : futures)
                join(future);

            for (var tp : threadParams)
                Console.writeLine("Result:%d", tp.getResult());

            threadPool.shutdown();
    }

    private static void generateAndFindTotalThreadCallback(ThreadParam param)
    {
        try {
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
        catch (Throwable ex) {

        }
    }

    public static void run(String[] args)
    {
        if (args.length != 4) {
            Console.Error.writeLine("Wrong number of arguments!...");
            System.exit(1);
        }

        try {
            doCalculate(parseInt(args[0]), parseInt(args[1]), parseInt(args[2]), parseInt(args[3]));
        }
        catch (NumberFormatException ignore) {
            Console.writeLine("Invalid arguments!...");
        }
    }
}

