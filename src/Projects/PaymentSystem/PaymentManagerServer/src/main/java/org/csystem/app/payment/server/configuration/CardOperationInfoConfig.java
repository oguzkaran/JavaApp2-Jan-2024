package org.csystem.app.payment.server.configuration;

import org.csystem.app.payment.server.manager.client.CardOperationInfo;
import org.csystem.app.payment.server.manager.client.ClientInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardOperationInfoConfig {
    private void sendInformationCallback(ClientInfo clientInfo)
    {
        var tcp = clientInfo.getTcp();

        tcp.sendLine(clientInfo.getPaymentServerInfo().serverInfo());
    }

    @Bean
    public CardOperationInfo firstCardOperationInfo()
    {
        return new CardOperationInfo(1, this::sendInformationCallback);
    }

    @Bean
    public CardOperationInfo secondCardOperationInfo()
    {
        return new CardOperationInfo(2, this::sendInformationCallback);
    }
}
