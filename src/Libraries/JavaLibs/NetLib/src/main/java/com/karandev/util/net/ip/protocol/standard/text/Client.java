/*----------------------------------------------------------------------
	FILE        : Client.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 21.04.2023

	Abstract super Client class for text based standard ip protocols

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.net.ip.protocol.standard.text;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;

public abstract class Client implements Closeable {
    protected Socket socket;

    @Override
    public void close() throws IOException
    {
        socket.close();
    }
}
