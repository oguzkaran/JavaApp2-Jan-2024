package org.csystem.app;

public class IntIncrementor {
    private int m_value1;
    private long m_value2;
    private final int m_count;

    private void incrementerCallback(int idx)
    {
        for (var i = 0; i < m_count; ++i)
            synchronized (this) {
                ++m_value1;
                m_value2 += m_value1;
            }
    }

    public IntIncrementor(int count)
    {
        m_count = count;
    }

    public int getValue1()
    {
        return m_value1;
    }

    public long getValue2()
    {
        return m_value2;
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
