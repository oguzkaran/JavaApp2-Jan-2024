package org.csystem.app.payment.server.manager.client;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class PaymentServerInfo {
    protected int id;

    public PaymentServerInfo(int id)
    {
        this.id = id;
    }

    public abstract String serverInfo();

    @Override
    public String toString()
    {
        return "%d".formatted(id);
    }
}
