package org.csystem.util.concurrent.random;

import org.csystem.util.string.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class RandomPasswordGenerator {
    private final int m_count;
    private final int m_min;
    private final int m_max;
    private final short m_nThreads;
    private final List<String> m_passwords;
    private final List<Future<?>> m_futures;
    private final Random m_random;
    private final ExecutorService m_threadPool;

    private void cancelThreads()
    {
        for (var future : m_futures)
            future.cancel(true);
    }

    private void submitThreads()
    {
        IntStream.range(0, m_nThreads).forEach(i -> m_futures.add(m_threadPool.submit(this::generateCallback)));
    }

    private void awaitFutures() throws ExecutionException, InterruptedException
    {
        for (var future : m_futures)
            future.get();
    }

    private void awaitFutures(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException
    {
        try {
            for (var future : m_futures)
                future.get(timeout, unit);
        }
        catch (TimeoutException ex) {
            cancelThreads();
            throw ex;
        }
    }

    private void generateCallback()
    {
        for (var i = 0; i < m_count && !Thread.interrupted(); ++i)
            synchronized (this) {
                m_passwords.add(StringUtil.getRandomTextEN(m_random, m_random.nextInt(m_max - m_min + 1)) + m_min);
            }
    }

    public RandomPasswordGenerator(int count, int min, int max, short nThreads, ExecutorService threadPool)
    {
        this(count, min, max, nThreads, new Random(), threadPool);
    }

    public RandomPasswordGenerator(int count, int min, int max, short nThreads, Random random, ExecutorService threadPool)
    {
        m_count = count;
        m_min = min;
        m_max = max;
        m_nThreads = nThreads;
        m_threadPool = threadPool;
        m_passwords = new ArrayList<>();
        m_random = random;
        m_futures = new ArrayList<>();
    }

    public List<String> getPasswords()
    {
        return m_passwords;
    }

    public int getSizeOfPasswords()
    {
        return m_passwords.size();
    }

    public List<Future<?>> run()
    {
        this.submitThreads();

        return m_futures;
    }

    public void await() throws ExecutionException, InterruptedException
    {
        awaitFutures();
    }

    public List<String> awaitAndGet() throws ExecutionException, InterruptedException
    {
        await();

        return m_passwords;
    }

    public void await(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException
    {
        awaitFutures(timeout, unit);
    }

    public List<String> awaitAndGet(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException
    {
        await(timeout, unit);

        return m_passwords;
    }
}
