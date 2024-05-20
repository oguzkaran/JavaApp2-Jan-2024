package org.csystem.app.payment.server.manager.client;

import java.util.Objects;

public class SocketPaymentServerInfo extends PaymentServerInfo {
    private String m_host;
    private int m_port;

    public SocketPaymentServerInfo(int id, String host, int port)
    {
        super(id);
        m_host = host;
        m_port = port;
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
    public String serverInfo()
    {
        return "%s:%d".formatted(m_host, m_port);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, m_host, m_port);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof SocketPaymentServerInfo ci
                && super.equals(other) && ci.m_host.equals(m_host)
                && ci.m_port == m_port;
    }

    @Override
    public String toString()
    {
        return "%d, %s:%d".formatted(id, m_host, m_port);
    }
}
