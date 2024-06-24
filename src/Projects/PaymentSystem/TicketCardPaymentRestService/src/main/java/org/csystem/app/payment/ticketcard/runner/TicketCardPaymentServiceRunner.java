package org.csystem.app.payment.ticketcard.runner;


import org.csystem.app.payment.ticketcard.client.InformationClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
public class TicketCardPaymentServiceRunner implements ApplicationRunner {
    private final InformationClient m_informationClient;
    //private final ExecutorService m_threadPool;
    private final ConfigurableApplicationContext m_applicationContext;


    public TicketCardPaymentServiceRunner(InformationClient informationClient, ConfigurableApplicationContext applicationContext)
    {
        m_informationClient = informationClient;
        m_applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args)
    {
        var thread = new Thread(m_informationClient::run);

        thread.setDaemon(true);
        thread.start();
    }
}
