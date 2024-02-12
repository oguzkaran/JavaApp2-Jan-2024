package org.csystem.app;

public class IntIncrementor {
    private static int ms_value1;
    private static long ms_value2;

    private static synchronized void doWorkForValues()
    {
        ++ms_value1;
        ms_value2 += ms_value1;
    }

    private static void incrementerCallback(int count, int idx)
    {
        for (var i = 0; i < count; ++i)
            doWorkForValues();
    }

    public static int getValue1()
    {
        return ms_value1;
    }

    public static long getValue2()
    {
        return ms_value2;
    }

    public static void run(int count, int nThreads)
    {
        Thread [] threads = new Thread[nThreads];

        for (var i = 0; i < nThreads; ++i) {
            var idx = i;

            threads[i] = new Thread(() -> incrementerCallback(count, idx), "Thread-");
            threads[i].start();
        }

        for (var t : threads)
            try {
                t.join();
            }
            catch (InterruptedException ignore) {

            }
    }
}
