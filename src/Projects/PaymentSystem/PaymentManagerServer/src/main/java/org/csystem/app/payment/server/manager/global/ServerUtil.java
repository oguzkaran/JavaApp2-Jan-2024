package org.csystem.app.payment.server.manager.global;

import org.csystem.app.payment.server.manager.client.PaymentServerInfo;

import java.util.HashMap;
import java.util.Map;

public final class ServerUtil {
    private ServerUtil()
    {
    }

    public static final Object SYNC_OBJECT = new Object();
    public static final Map<Integer, PaymentServerInfo> SERVERS = new HashMap<>();

    //...
}
