package org.csystem.app.payment.creditcard.runner;


import org.csystem.app.payment.creditcard.client.InformationClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentServerRunner implements ApplicationRunner {
    private final InformationClient m_informationClient;

    public CreditCardPaymentServerRunner(InformationClient informationClient)
    {
        m_informationClient = informationClient;
    }

    @Override
    public void run(ApplicationArguments args)
    {
        var thread = new Thread(m_informationClient::run);

        thread.setDaemon(false);
        thread.start();
    }
}
