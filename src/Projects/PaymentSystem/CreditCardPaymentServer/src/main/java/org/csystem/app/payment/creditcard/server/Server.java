package org.csystem.app.payment.creditcard.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.karandev")
@Slf4j
public class Server {
    //...
    public void run()
    {
        //...
        log.info("Server started");
    }
}
