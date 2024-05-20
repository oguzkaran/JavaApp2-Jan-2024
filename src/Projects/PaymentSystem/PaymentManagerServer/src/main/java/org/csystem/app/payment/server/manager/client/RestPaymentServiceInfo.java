package org.csystem.app.payment.server.manager.client;

import java.util.Objects;

public class RestPaymentServiceInfo extends PaymentServerInfo {

    private String m_endPoint;

    public RestPaymentServiceInfo(int id, String endPoint)
    {
        super(id);
        m_endPoint = endPoint;
    }

    @Override
    public String serverInfo()
    {
        return m_endPoint;
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
        return Objects.hash(id, m_endPoint);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof RestPaymentServiceInfo ti
                && super.equals(other) && ti.m_endPoint.equals(m_endPoint);
    }

    @Override
    public String toString()
    {
        return "%d, %s".formatted(id, m_endPoint);
    }
}
