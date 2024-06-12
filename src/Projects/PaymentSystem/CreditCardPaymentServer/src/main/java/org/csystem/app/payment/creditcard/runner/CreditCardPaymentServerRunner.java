package org.csystem.app.payment.creditcard.runner;


import org.csystem.app.payment.creditcard.client.InformationClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
public class CreditCardPaymentServerRunner implements ApplicationRunner {
    private final InformationClient m_informationClient;
    private final ExecutorService m_threadPool;

    public CreditCardPaymentServerRunner(InformationClient informationClient, ExecutorService threadPool)
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
