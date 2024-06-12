package org.csystem.app.payment.ticketcard.configuration.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.Socket;

@Configuration
@Slf4j
public class SocketConfig {
    @Bean("app.socket.information")
    public Socket informationSocket(@Value("${app.host.manager}") String managerHost,
                                    @Value("${app.port.manager}") int managerPort) throws IOException
    {
        log.info("Manager Server Information: {}:{}", managerHost, managerPort);

        return new Socket(managerHost, managerPort);
    }
}
