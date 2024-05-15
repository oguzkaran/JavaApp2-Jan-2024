package org.csystem.app.payment.server.manager.client;

import com.karandev.util.net.TCP;

import java.util.Objects;

public abstract class PaymentServerInfo {
    protected int id;

    public PaymentServerInfo(int id)
    {
        this.id = id;
    }

    public abstract String serverInfo();

    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PaymentServerInfo ci
                && ci.id == id;
    }

    @Override
    public String toString()
    {
        return "%d".formatted(id);
    }


}
