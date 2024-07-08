package org.csystem.app.payment.server.manager.client;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class PaymentServerInfo {
    protected String id;

    public PaymentServerInfo(String id)
    {

    }

    public abstract String serverInfo();

    @Override
    public String toString()
    {
        return "%d".formatted(id);
    }
}
