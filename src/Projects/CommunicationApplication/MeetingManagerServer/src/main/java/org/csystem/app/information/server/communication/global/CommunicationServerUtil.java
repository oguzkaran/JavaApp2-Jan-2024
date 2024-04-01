package org.csystem.app.information.server.communication.global;

import org.csystem.app.information.server.communication.client.CommunicationServerInfo;

import java.util.HashSet;
import java.util.Set;

public final class CommunicationServerUtil {
    private CommunicationServerUtil()
    {
    }

    public static final Set<CommunicationServerInfo> SERVERS = new HashSet<>();
    //...
}
