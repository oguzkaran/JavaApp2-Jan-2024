package org.csystem.app.payment.server.communication.client;

public class PaymentServerInfo {
    protected String name;

    protected PaymentServerInfo(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PaymentServerInfo ci
                && ci.name.equals(name);
    }

    @Override
    public String toString()
    {
        return "%s".formatted(name);
    }
}
