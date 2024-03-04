/*----------------------------------------------------------------------
    FILE        : HttpConnection.java
    AUTHOR      : Oguz Karan
    LAST UPDATE : 20.03.2020

    HttpConnection class for socket applications

    Copyleft (c) 1993 by C and System Programmers Association (CSD)
    All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.net.http;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.security.Permission;
import java.util.List;
import java.util.Map;

public final class HttpConnection implements Closeable {
    private final HttpURLConnection m_httpURLConnection;

    public HttpConnection(String urlStr) throws IOException
    {
        this(new URL(urlStr));
    }

    public HttpConnection(URL url) throws IOException
    {
        m_httpURLConnection = (HttpURLConnection)url.openConnection();
    }

    public HttpURLConnection getHttpURLConnection()
    {
        return m_httpURLConnection;
    }

    public String getHeaderFieldKey(int n)
    {
        return m_httpURLConnection.getHeaderFieldKey(n);
    }

    public void setFixedLengthStreamingMode(int contentLength)
    {
        m_httpURLConnection.setFixedLengthStreamingMode(contentLength);
    }

    public void setFixedLengthStreamingMode(long contentLength)
    {
        m_httpURLConnection.setFixedLengthStreamingMode(contentLength);
    }

    public void setChunkedStreamingMode(int chunklen)
    {
        m_httpURLConnection.setChunkedStreamingMode(chunklen);
    }

    public String getHeaderField(int n)
    {
        return m_httpURLConnection.getHeaderField(n);
    }

    public static void setFollowRedirects(boolean set)
    {
        HttpURLConnection.setFollowRedirects(set);
    }

    public static boolean getFollowRedirects()
    {
        return HttpURLConnection.getFollowRedirects();
    }

    public void setInstanceFollowRedirects(boolean followRedirects)
    {
        m_httpURLConnection.setInstanceFollowRedirects(followRedirects);
    }

    public boolean getInstanceFollowRedirects()
    {
        return m_httpURLConnection.getInstanceFollowRedirects();
    }

    public void setRequestMethod(String method) throws ProtocolException
    {
        m_httpURLConnection.setRequestMethod(method);
    }

    public String getRequestMethod()
    {
        return m_httpURLConnection.getRequestMethod();
    }

    public int getResponseCode() throws IOException
    {
        return m_httpURLConnection.getResponseCode();
    }

    public String getResponseMessage() throws IOException
    {
        return m_httpURLConnection.getResponseMessage();
    }

    public long getHeaderFieldDate(String name, long Default)
    {
        return m_httpURLConnection.getHeaderFieldDate(name, Default);
    }

    public void disconnect()
    {
        m_httpURLConnection.disconnect();
    }

    public boolean usingProxy()
    {
        return m_httpURLConnection.usingProxy();
    }

    public Permission getPermission() throws IOException
    {
        return m_httpURLConnection.getPermission();
    }

    public InputStream getErrorStream()
    {
        return m_httpURLConnection.getErrorStream();
    }

    public static FileNameMap getFileNameMap()
    {
        return URLConnection.getFileNameMap();
    }

    public static void setFileNameMap(FileNameMap map)
    {
        URLConnection.setFileNameMap(map);
    }

    public void connect() throws IOException
    {
        m_httpURLConnection.connect();
    }

    public void setConnectTimeout(int timeout)
    {
        m_httpURLConnection.setConnectTimeout(timeout);
    }

    public int getConnectTimeout()
    {
        return m_httpURLConnection.getConnectTimeout();
    }

    public void setReadTimeout(int timeout)
    {
        m_httpURLConnection.setReadTimeout(timeout);
    }

    public int getReadTimeout()
    {
        return m_httpURLConnection.getReadTimeout();
    }

    public URL getURL()
    {
        return m_httpURLConnection.getURL();
    }

    public int getContentLength()
    {
        return m_httpURLConnection.getContentLength();
    }

    public long getContentLengthLong()
    {
        return m_httpURLConnection.getContentLengthLong();
    }

    public String getContentType()
    {
        return m_httpURLConnection.getContentType();
    }

    public String getContentEncoding()
    {
        return m_httpURLConnection.getContentEncoding();
    }

    public long getExpiration()
    {
        return m_httpURLConnection.getExpiration();
    }

    public long getDate()
    {
        return m_httpURLConnection.getDate();
    }

    public long getLastModified()
    {
        return m_httpURLConnection.getLastModified();
    }

    public String getHeaderField(String name)
    {
        return m_httpURLConnection.getHeaderField(name);
    }

    public Map<String, List<String>> getHeaderFields()
    {
        return m_httpURLConnection.getHeaderFields();
    }

    public int getHeaderFieldInt(String name, int Default)
    {
        return m_httpURLConnection.getHeaderFieldInt(name, Default);
    }

    public long getHeaderFieldLong(String name, long Default)
    {
        return m_httpURLConnection.getHeaderFieldLong(name, Default);
    }

    public Object getContent() throws IOException
    {
        return m_httpURLConnection.getContent();
    }

    public Object getContent(Class<?>[] classes) throws IOException
    {
        return m_httpURLConnection.getContent(classes);
    }

    public InputStream getInputStream() throws IOException
    {
        return m_httpURLConnection.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException
    {
        return m_httpURLConnection.getOutputStream();
    }

    public void setDoInput(boolean doinput)
    {
        m_httpURLConnection.setDoInput(doinput);
    }

    public boolean getDoInput()
    {
        return m_httpURLConnection.getDoInput();
    }

    public void setDoOutput(boolean dooutput)
    {
        m_httpURLConnection.setDoOutput(dooutput);
    }

    public boolean getDoOutput()
    {
        return m_httpURLConnection.getDoOutput();
    }

    public void setAllowUserInteraction(boolean allowuserinteraction)
    {
        m_httpURLConnection.setAllowUserInteraction(allowuserinteraction);
    }

    public boolean getAllowUserInteraction()
    {
        return m_httpURLConnection.getAllowUserInteraction();
    }

    public static void setDefaultAllowUserInteraction(boolean defaultallowuserinteraction)
    {
        URLConnection.setDefaultAllowUserInteraction(defaultallowuserinteraction);
    }

    public static boolean getDefaultAllowUserInteraction()
    {
        return URLConnection.getDefaultAllowUserInteraction();
    }

    public void setUseCaches(boolean usecaches)
    {
        m_httpURLConnection.setUseCaches(usecaches);
    }

    public boolean getUseCaches()
    {
        return m_httpURLConnection.getUseCaches();
    }

    public void setIfModifiedSince(long ifmodifiedsince)
    {
        m_httpURLConnection.setIfModifiedSince(ifmodifiedsince);
    }

    public long getIfModifiedSince()
    {
        return m_httpURLConnection.getIfModifiedSince();
    }

    public boolean getDefaultUseCaches()
    {
        return m_httpURLConnection.getDefaultUseCaches();
    }

    public void setDefaultUseCaches(boolean defaultusecaches)
    {
        m_httpURLConnection.setDefaultUseCaches(defaultusecaches);
    }

    public void setRequestProperty(String key, String value)
    {
        m_httpURLConnection.setRequestProperty(key, value);
    }

    public void addRequestProperty(String key, String value)
    {
        m_httpURLConnection.addRequestProperty(key, value);
    }

    public String getRequestProperty(String key)
    {
        return m_httpURLConnection.getRequestProperty(key);
    }

    public Map<String, List<String>> getRequestProperties()
    {
        return m_httpURLConnection.getRequestProperties();
    }

    public static void setContentHandlerFactory(ContentHandlerFactory fac)
    {
        URLConnection.setContentHandlerFactory(fac);
    }

    public static String guessContentTypeFromName(String fname)
    {
        return URLConnection.guessContentTypeFromName(fname);
    }

    public static String guessContentTypeFromStream(InputStream is) throws IOException
    {
        return URLConnection.guessContentTypeFromStream(is);
    }

    @Override
    public void close()
    {
        m_httpURLConnection.disconnect();
    }
}
