package org.csystem.app.information.server.communication.global;

import org.csystem.app.information.server.communication.client.InformationServerInfo;

import java.util.HashSet;
import java.util.Set;

public final class Global {
    private Global()
    {
    }

    public static final Set<InformationServerInfo> INFORMATION_SERVER_INFO = new HashSet<>();
    //...
}
