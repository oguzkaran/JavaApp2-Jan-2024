package org.csystem.app.payment.server.manager.client;

import com.karandev.util.net.TCP;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class ClientInfo {
    @Accessors(prefix = "m_") private TCP m_tcp;
    @Accessors(prefix = "m_") private PaymentServerInfo m_paymentServerInfo;

    public ClientInfo(TCP tcp, PaymentServerInfo paymentServerInfo)
    {
        m_tcp = tcp;
        m_paymentServerInfo = paymentServerInfo;
    }
}