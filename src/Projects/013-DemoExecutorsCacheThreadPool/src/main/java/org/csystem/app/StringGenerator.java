package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.random.RandomGenerator;

public class StringGenerator {
    private final List<String> m_list;

    private final int m_min;
    private final int m_bound;
    private final int m_count;

    private final RandomGenerator m_randomGenerator;
    private final ExecutorService m_threadPool;

    private void generateCallback()
    {
        var self = Thread.currentThread();

        for (var i = 0; i < m_count; ++i)
            synchronized (this) {
                m_list.add(String.format("%s:%s", self.getName(), StringUtil.getRandomTextEN(m_randomGenerator, m_randomGenerator.nextInt(5, 15))));
                m_list.add(String.format("%s:%s", self.getName(), StringUtil.getRandomTextEN(m_randomGenerator, m_randomGenerator.nextInt(1, 15))));
            }
    }

    public StringGenerator(List<String> list, int min, int bound, int count, RandomGenerator randomGenerator)
    {
        m_list = list;
        m_min = min;
        m_bound = bound;
        m_count = count;
        m_randomGenerator = randomGenerator;
        m_threadPool = Executors.newCachedThreadPool();
    }

    public int size()
    {
        return m_list.size();
    }

    public void run()
    {
        Future<?> [] futures = new Future[m_randomGenerator.nextInt(m_min, m_bound)];

        Console.writeLine("Number of threads needed:%s", futures.length);

        for (var i = 0; i < futures.length; ++i)
            futures[i] = m_threadPool.submit(this::generateCallback);

        m_threadPool.shutdown();

        for (var future : futures)
            try {
                future.get();
            }
            catch (ExecutionException | InterruptedException ignore) {

            }

        for (var str : m_list)
            Console.writeLine(str);
    }
}
