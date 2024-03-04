/*----------------------------------------------------------------------
	FILE        : Pop3Client.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 21.04.2023

	Pop3Client class for POP3 protocol operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.net.ip.protocol.standard.text;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public final class Pop3Client extends Client implements ILogin {
    private final String m_username;
    private final String m_password;
    private final BufferedWriter m_bw;
    private final BufferedReader m_br;

    private List<String> getResult() throws IOException
    {
        String text;
        var result = new ArrayList<String>();

        while (!(text = m_br.readLine()).equals("."))
            result.add(text);

        return result;
    }

    private boolean login(String username, String password) throws IOException
    {
        m_bw.write(String.format("USER %s\r\n", username));
        m_bw.flush();
        var result = m_br.readLine();

        if (result.startsWith("-ERR"))
            return false;

        m_bw.write(String.format("PASS %s\r\n", password));
        m_bw.flush();
        result = m_br.readLine();

        return result.startsWith("+OK");
    }

    public Pop3Client(String server, String username, String password) throws IOException
    {
        m_username = username;
        m_password = password;
        socket = new Socket(server, 110);
        m_br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        m_bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public boolean login() throws IOException
    {
        return login(m_username, m_password);
    }

    @Override
    public boolean logout() throws IOException
    {
        m_bw.write("QUIT %s\r\n");
        m_bw.flush();
        m_br.readLine();

        return true;
    }

    public List<String> listEmail() throws IOException
    {
        m_bw.write("LIST\r\n");
        m_bw.flush();

        return getResult();
    }

    public List<String> retreiveEmail(int no) throws IOException
    {
        m_bw.write(String.format("RETR %d\r\n", no));
        m_bw.flush();

        return getResult();
    }

    //...

    @Override
    public void close() throws IOException
    {
        logout();
        super.close();
    }
}
