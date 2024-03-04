/*----------------------------------------------------------------------
FILE        : NetworkException.java
AUTHOR      : Oguz Karan
LAST UPDATE : 07.10.2021

Unnchecked exception class for network applications

Copyleft (c) 1993 by C and System Programmers Association (CSD)
All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.net.exception;

public class NetworkException extends RuntimeException {
    public NetworkException()
    {
    }
    
    public NetworkException(String message)
    {
        this(message, null);
    }

    public NetworkException(String message, Throwable cause)
    {
        super(message, cause);
    }

    @Override
    public String getMessage()
    {
        Throwable cause = getCause();

        return String.format("{message : %s%s", super.getMessage(), cause != null ? ", causeMessage : " + cause.getMessage()  + "}": "}");
    }
}
