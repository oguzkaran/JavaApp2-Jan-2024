package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ProducerConsumer {
    private final ExecutorService m_executorService = Executors.newFixedThreadPool(2);
    private final Semaphore m_semaphoreProducer = new Semaphore(1);
    private final Semaphore m_semaphoreConsumer = new Semaphore(0);
    private int m_value = -1;

    private Void producerCallback() throws InterruptedException
    {
        var random = new Random();
        var value = 0;

        while (true) {
            m_semaphoreProducer.acquire();
            m_value = value++;
            m_semaphoreConsumer.release();

            if (value == 100)
                break;

            Thread.sleep(random.nextLong(10, 200));
        }

        return null;
    }

    private Void consumerCallback() throws InterruptedException
    {
        var random = new Random();
        int value;

        while (true) {
            m_semaphoreConsumer.acquire();
            value = m_value;
            m_semaphoreProducer.release();

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
