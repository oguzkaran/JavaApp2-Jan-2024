package org.csystem.app.payment.server.runner;

import com.karandev.io.util.console.CommandPrompt;
import org.csystem.app.payment.server.manager.manage.PaymentManagerServerCommands;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PaymentManagerApplicationRunner implements ApplicationRunner {
    private final PaymentManagerServerCommands m_paymentManagerServerCommands;

    public PaymentManagerApplicationRunner(PaymentManagerServerCommands paymentManagerServerCommands)
    {
        m_paymentManagerServerCommands = paymentManagerServerCommands;
    }

    @Override
    public void run(ApplicationArguments args)
    {
        CommandPrompt.builder()
                .prompt("payment-manager")
                .build()
                .registerObject(m_paymentManagerServerCommands)
                .run();
    }
}
