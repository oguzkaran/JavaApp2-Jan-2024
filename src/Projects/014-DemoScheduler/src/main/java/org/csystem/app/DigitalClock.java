package org.csystem.app;

import com.karandev.util.console.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DigitalClock {
    private final DateTimeFormatter m_formatter;
    private final ScheduledExecutorService m_scheduledExecutorService;

    public DigitalClock()
    {
        m_formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH.mm.ss");
        m_scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void run()
    {
        var future = m_scheduledExecutorService.scheduleAtFixedRate(() -> Console.write("%s\r", m_formatter.format(LocalDateTime.now())), 0, 1, TimeUnit.SECONDS);

        Console.readLine();
        future.cancel(false);
        m_scheduledExecutorService.shutdown();
    }
}
