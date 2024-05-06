package org.csystem.app.payment.server.communication.client;

import java.util.Objects;

public class TicketCardPaymentServiceInfo extends PaymentServerInfo {

    private String m_endPoint;

    public TicketCardPaymentServiceInfo(String name, String endPoint)
    {
        super(name);
        m_endPoint = endPoint;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEndPoint()
    {
        return m_endPoint;
    }

    public void setEndPoint(String endPoint)
    {
        m_endPoint = endPoint;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, m_endPoint);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof TicketCardPaymentServiceInfo ti
                && ti.name.equals(name) && ti.m_endPoint.equals(m_endPoint);
    }

    @Override
    public String toString()
    {
        return "%s, %s".formatted(name, m_endPoint);
    }
}
