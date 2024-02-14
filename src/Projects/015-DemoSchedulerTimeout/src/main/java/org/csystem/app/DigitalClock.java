package org.csystem.app;

import com.karandev.util.console.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DigitalClock {
    private final DateTimeFormatter m_formatter;
    private final ScheduledExecutorService m_scheduledExecutorService;
    private final int m_timeoutValue;
    private final TimeUnit m_timeUnit;

    public DigitalClock(int timeoutValue, TimeUnit timeUnit)
    {
        m_formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH.mm.ss");
        m_scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        m_timeoutValue = timeoutValue;
        m_timeUnit = timeUnit;
    }

    public void run()
    {
        Console.writeLine("%s", m_formatter.format(LocalDateTime.now()));
        var future = m_scheduledExecutorService.schedule(() -> Console.writeLine("%s", m_formatter.format(LocalDateTime.now())), m_timeoutValue, m_timeUnit);

        try {
            future.get();
        }
        catch (ExecutionException | InterruptedException ignore){

        }

        m_scheduledExecutorService.shutdown();
    }
}
