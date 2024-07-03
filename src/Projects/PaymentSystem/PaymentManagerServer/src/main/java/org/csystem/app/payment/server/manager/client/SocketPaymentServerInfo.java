package org.csystem.app.payment.server.manager.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SocketPaymentServerInfo extends PaymentServerInfo {
    @Accessors(prefix = "m_")
    private String m_host;

    @Accessors(prefix = "m_")
    private int m_port;

    public SocketPaymentServerInfo(int id, String host, int port)
    {
        super(id);
        m_host = host;
        m_port = port;
    }

    @Override
    public String serverInfo()
    {
        return "%s:%d".formatted(m_host, m_port);
    }

}
