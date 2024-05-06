/*----------------------------------------------------------------------
	FILE        : TCP.java
	AUTHOR      : JavaApp2-Jan-2024 Group
	LAST UPDATE : 6th May 2024

	Immutable TCP class for TCP socket operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.net;

import com.karandev.util.net.exception.NetworkException;

import java.io.File;
import java.net.Socket;
import java.nio.charset.Charset;

public class TCP {
    private final Socket m_socket;

    public TCP(Socket socket)
    {
        m_socket = socket;
    }

    public TCP(Socket socket, int timeout)
    {
        try {
            m_socket = socket;
            socket.setSoTimeout(timeout);
        }
        catch (Throwable ex) {
            throw new NetworkException("TCP(socket, timeout)", ex);
        }
    }

    public boolean isOpen()
    {
        return !m_socket.isClosed();
    }

    public Socket getSocket()
    {
        return m_socket;
    }

    public int receive(byte [] data, int offset, int length)
    {
        return TcpUtil.receive(m_socket, data, offset, length);
    }

    public int receive(byte [] data)
    {
        return TcpUtil.receive(m_socket, data);
    }

    public int send(byte [] data, int offset, int length)
    {
        return TcpUtil.send(m_socket, data, offset, length);
    }

    public int send(byte [] data)
    {
        return TcpUtil.send(m_socket, data);
    }

    public byte receiveByte()
    {
        return TcpUtil.receiveByte(m_socket);
    }

    public short receiveShort()
    {
        return TcpUtil.receiveShort(m_socket);
    }

    public int receiveInt()
    {
        return TcpUtil.receiveInt(m_socket);
    }

    public long receiveLong()
    {
        return TcpUtil.receiveLong(m_socket);
    }

    public float receiveFloat()
    {
        return TcpUtil.receiveFloat(m_socket);
    }

    public double receiveDouble()
    {
        return TcpUtil.receiveDouble(m_socket);
    }

    public char receiveChar()
    {
        return TcpUtil.receiveChar(m_socket);
    }

    public String receiveStringViaLength()
    {
        return TcpUtil.receiveStringViaLength(m_socket);
    }

    public String receiveStringViaLength(Charset charset)
    {
        return TcpUtil.receiveStringViaLength(m_socket, charset);
    }

    public String receiveString(int length)
    {
        return TcpUtil.receiveString(m_socket, length);
    }

    public String receiveString(int length, Charset charset)
    {
        return TcpUtil.receiveString(m_socket, length, charset);
    }

    public String receiveLine()
    {
        return TcpUtil.receiveLine(m_socket);
    }

    public String receiveLine(Charset charset)
    {
        return TcpUtil.receiveLine(m_socket, charset);
    }

    public String receiveLine(int blockSize)
    {
        return TcpUtil.receiveLine(m_socket, blockSize);
    }

    public String receiveLine(Charset charset, int blockSize)
    {
        return TcpUtil.receiveLine(m_socket, charset, blockSize);
    }

    public void receiveFile(File file)
    {
        TcpUtil.receiveFile(m_socket, file);
    }

    public void receiveFile(String path)
    {
        TcpUtil.receiveFile(m_socket, path);
    }

    public void sendByte(byte val)
    {
        TcpUtil.sendByte(m_socket, val);
    }

    public void sendShort(short val)
    {
        TcpUtil.sendShort(m_socket, val);
    }

    public void sendInt(int val)
    {
        TcpUtil.sendInt(m_socket, val);
    }

    public void sendLong(long val)
    {
        TcpUtil.sendLong(m_socket, val);
    }

    public void sendFloat(float val)
    {
        TcpUtil.sendFloat(m_socket, val);
    }

    public void sendDouble(double val)
    {
        TcpUtil.sendDouble(m_socket, val);
    }

    public void sendChar(char val)
    {
        TcpUtil.sendChar(m_socket, val);
    }

    public void sendStringViaLength(String str)
    {
        TcpUtil.sendStringViaLength(m_socket, str);
    }

    public void sendStringViaLength(String str, Charset charset)
    {
        TcpUtil.sendStringViaLength(m_socket, str, charset);
    }

    public void sendString(String str)
    {
        TcpUtil.sendString(m_socket, str);
    }

    public void sendString(String str, Charset charset)
    {
        TcpUtil.sendString(m_socket, str, charset);
    }

    public void sendLine(String str)
    {
        TcpUtil.sendLine(m_socket, str);
    }

    public void sendLine(String str, Charset charset)
    {
        TcpUtil.sendLine(m_socket, str, charset);
    }

    public void sendFile(File file, int blockSize)
    {
        TcpUtil.sendFile(m_socket, file, blockSize);
    }

    public void sendFile(String path, int blockSize)
    {
        TcpUtil.sendFile(m_socket, path, blockSize);
    }
}
