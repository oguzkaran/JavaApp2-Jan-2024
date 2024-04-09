package org.csystem.communication.library.common.message;

public final class CommunicationMessage {
    private CommunicationMessage()
    {
    }

    public static final String SUCCESS = "SUC";
    public static final String ERROR = "ERR";
    public static final String SUCCESS_INFO = "SUC_INFO";
    public static final String ERROR_INFO = "ERR_INFO";
    public static final String ERROR_INVALID_ID = "ERR_INVALID_ID";
    public static final String ERROR_INTERNAL = "ERR_INTERNAL";
    public static final String SUCCESS_PORT = "SUC_PORT";
    public static final String ERROR_INVALID_PORT = "ERR_INVALID_PORT";
}
