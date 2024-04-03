package org.csystem.app.information.server.communication.client;

public class CommunicationServerInfo {
    private String m_name;
    private String m_host;
    private int m_port;

    public CommunicationServerInfo()
    {
    }

    public CommunicationServerInfo(String name, String host, int port)
    {
        m_name = name;
        m_host = host;
        m_port = port;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
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
        return m_host.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof CommunicationServerInfo ci && m_host.equals(ci.m_host);
    }

    @Override
    public String toString()
    {
        return String.format("%s, %s:%d", m_name, m_host, m_port);
    }
}
