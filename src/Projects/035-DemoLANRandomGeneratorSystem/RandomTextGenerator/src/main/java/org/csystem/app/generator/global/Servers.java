package org.csystem.app.generator.global;

import org.csystem.app.generator.ServerInfo;

import java.util.ArrayList;
import java.util.List;

public class Servers {
    public static final List<ServerInfo> SERVERS = new ArrayList<>();
    public static final Object SYNC_LOCK = new Object();
}
