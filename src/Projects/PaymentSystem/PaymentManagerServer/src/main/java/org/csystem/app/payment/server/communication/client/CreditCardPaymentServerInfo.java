package org.csystem.app.payment.server.communication.client;

import java.util.Objects;

public class CreditCardPaymentServerInfo extends PaymentServerInfo {
    private String m_host;
    private int m_port;

    public CreditCardPaymentServerInfo(String name, String host, int port)
    {
        super(name);
        m_host = host;
        m_port = port;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getHost()
    {
        return m_host;
    }

    public void setHost(String host)
    {
        m_host = host;
    }

    public int getPort()
    {
        return m_port;
    }

    public void setPort(int port)
    {
        m_port = port;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, m_host, m_port);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof CreditCardPaymentServerInfo ci
                && super.equals(other) && ci.m_host.equals(m_host)
                && ci.m_port == m_port;
    }

    @Override
    public String toString()
    {
        return "%s, %s:%d".formatted(name, m_host, m_port);
    }
}
