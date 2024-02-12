package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.random.RandomGenerator;

public class StringGenerator {
    private final List<String> m_list;
    private final int m_count;
    private final RandomGenerator m_randomGenerator;

    private void generateCallback()
    {
        var self = Thread.currentThread();

        for (var i = 0; i < m_count; ++i)
            m_list.add(String.format("%s:%s", self.getName(), StringUtil.getRandomTextEN(m_randomGenerator, m_randomGenerator.nextInt(5, 15))));
    }

    public StringGenerator(List<String> list, int count, RandomGenerator randomGenerator)
    {
        m_list = Collections.synchronizedList(list);
        m_count = count;
        m_randomGenerator = randomGenerator;
    }

    public int size()
    {
        return m_list.size();
    }

    public void run(int nThreads)
    {
        Thread [] threads = new Thread[nThreads];

        for (var i = 0; i < nThreads; ++i) {
            threads[i] = new Thread(this::generateCallback);
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
