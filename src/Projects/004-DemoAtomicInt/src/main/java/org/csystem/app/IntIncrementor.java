package org.csystem.app;

import java.util.concurrent.atomic.AtomicInteger;

public class IntIncrementor {
    private final AtomicInteger m_value;
    private final int m_count;

    private void incrementerCallback(int idx)
    {

        for (var i = 0; i < m_count; ++i)
            m_value.getAndIncrement();

        /*
            ++m_value;

            mov reg, m_value
            add reg, 1
            mov m_value, 1
         */
    }

    public IntIncrementor(int count)
    {
        m_count = count;
        m_value = new AtomicInteger();
    }

    public int getValue()
    {
        return m_value.get();
    }

    public int getCount()
    {
        return m_count;
    }

    public void run(int nThreads)
    {
        Thread [] threads = new Thread[nThreads];

        for (var i = 0; i < nThreads; ++i) {
            var idx = i;

            threads[i] = new Thread(() -> incrementerCallback(idx), "Thread-");
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
