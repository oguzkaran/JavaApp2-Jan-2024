package org.csystem.util.concurrent.random;

import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomGenerator implements Runnable {
    private int m_total;
    private final int m_count;
    private final int m_min;
    private final int m_max;
    private final Random m_random;
    private final long m_ms;
    private Thread m_thread;

    public RandomGenerator(int count, int min, int max, long ms, TimeUnit unit, Random random, boolean start)
    {
        m_count = count;
        m_min = min;
        m_max = max;
        m_random = random;
        m_ms = TimeUnit.MILLISECONDS.convert(ms, unit);
        if (start) {
            m_thread = new Thread(this);
            m_thread.start();
        }
    }

    public RandomGenerator(int count, int min, int max, long ms, TimeUnit unit, Random random)
    {
        this(count, min, max, ms, unit, random, false);
    }

    public int getTotal()
    {
        return m_total;
    }

    @Override
    public void run()
    {
        for (var i = 0; i < m_count; ++i) {
            int val = m_random.nextInt(m_max - m_min + 1) + m_min;

            Console.write("%d ", val);
            m_total += val;
            ThreadUtil.sleep(m_ms);
        }
    }

    public void await() throws InterruptedException
    {
        m_thread.join();
    }

    public int awaitAndGet() throws InterruptedException
    {
        await();

        return m_total;
    }
}
