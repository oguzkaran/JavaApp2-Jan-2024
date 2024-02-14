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
    private final int m_count;
    private final int m_nThreads;
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

    public StringGenerator(List<String> list, int count, int nThreads, RandomGenerator randomGenerator)
    {
        m_list = list;
        m_count = count;
        m_randomGenerator = randomGenerator;
        m_nThreads = nThreads;
        m_threadPool = Executors.newFixedThreadPool(m_nThreads);
    }

    public int size()
    {
        return m_list.size();
    }

    public void run()
    {
        Future<?> [] futures = new Future[m_nThreads];

        for (var i = 0; i < m_nThreads; ++i)
            futures[i] = m_threadPool.submit(this::generateCallback);

        for (var future : futures)
            try {
                future.get();
            }
            catch (ExecutionException | InterruptedException ignore) {

            }

        for (var str : m_list)
            Console.writeLine(str);

        m_threadPool.shutdown();
    }
}
