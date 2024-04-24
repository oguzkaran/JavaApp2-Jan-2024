package org.csystem.app.generator;

import java.util.Objects;

public class ServerInfo {
    private final String m_host;
    private final int m_port;
    private boolean m_active;

    public ServerInfo(String host, int port)
    {
        m_host = host;
        m_port = port;
        m_active = true;
    }

    public String getHost()
    {
        return m_host;
    }

    public int getPort()
    {
        return m_port;
    }

    public boolean isActive()
    {
        return m_active;
    }

    public void setActive(boolean active)
    {
        m_active = active;
    }

    @Override
    public String toString()
    {
        return "%s:%d".formatted(m_host, m_port);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof ServerInfo si && si.m_host.equals(m_host) && si.m_port == m_port;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(m_host, m_port);
    }
}
