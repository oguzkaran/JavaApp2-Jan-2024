package org.csystem.app.thread;

import org.csystem.util.string.StringUtil;

import java.util.Random;

public class RandomTextGeneratorThread extends Thread {
    private final Random m_random = new Random();
    private final int m_count;
    private final int m_min;
    private final int m_bound;

    public RandomTextGeneratorThread(String name, int count, int min, int bound)
    {
        super(name);
        m_count = count;
        m_min = min;
        m_bound = bound;
    }

    @Override
    public void run()
    {
        for (var i = 0; i < m_count; ++i) {
            var text = StringUtil.getRandomTextEN(m_random, m_random.nextInt(m_min, m_bound));

            System.out.printf("%s -> %s%n", getName(), text);
            //ThreadUtil.sleep(m_random.nextLong(300, 501));
        }
    }
}
