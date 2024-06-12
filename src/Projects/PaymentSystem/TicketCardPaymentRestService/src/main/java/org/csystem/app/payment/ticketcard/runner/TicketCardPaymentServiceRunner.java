package org.csystem.app.payment.ticketcard.runner;


import org.csystem.app.payment.ticketcard.client.InformationClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
public class TicketCardPaymentServiceRunner implements ApplicationRunner {
    private final InformationClient m_informationClient;
    private final ExecutorService m_threadPool;

    public TicketCardPaymentServiceRunner(InformationClient informationClient, ExecutorService threadPool)
    {
        m_informationClient = informationClient;
        m_threadPool = threadPool;
    }

    @Override
    public void run(ApplicationArguments args)
    {
        m_threadPool.execute(m_informationClient::run);
    }
}
