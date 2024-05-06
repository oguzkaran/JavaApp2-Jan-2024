package org.csystem.app.payment.server.communication.global;

import org.csystem.app.payment.server.communication.client.CreditCardPaymentServerInfo;
import org.csystem.app.payment.server.communication.client.TicketCardPaymentServiceInfo;

import java.util.HashSet;
import java.util.Set;

public final class ServerUtil {
    private ServerUtil()
    {
    }

    public static final Object SYNC_SERVERS_OBJECT = new Object();

    public static final Set<CreditCardPaymentServerInfo> SERVERS = new HashSet<>();
    public static final Set<TicketCardPaymentServiceInfo> SERVICES = new HashSet<>();

    //...
}
