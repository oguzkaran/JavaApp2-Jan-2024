package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {
    private final ExecutorService m_executorService = Executors.newFixedThreadPool(2);
    private int m_value = -1;

    private Void producerCallback() throws InterruptedException
    {
        var random = new Random();
        var value = 0;

        while (true) {
            m_value = value++;

            if (value == 100)
                break;

            Thread.sleep(random.nextLong(10, 200));
        }

        return null;
    }

    private Void consumerCallback() throws InterruptedException
    {
        var random = new Random();

        while (true) {
            var value = m_value;

            Console.write("%d ", value);
            if (value >= 99)
                break;

            Thread.sleep(random.nextLong(10, 200));
        }

        return null;
    }

    public void run()
    {
        m_executorService.submit(this::producerCallback);
        m_executorService.submit(this::consumerCallback);
        m_executorService.shutdown();
    }
}
