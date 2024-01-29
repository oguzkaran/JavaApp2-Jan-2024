package org.csystem.challenge.string;

public class CSDStringBuilder {
    private static final int DEFAULT_CAPACITY = 16;
    private char [] m_chars;
    private int m_index;

    private void allocate(int newCapacity)
    {
        var chars = new char[newCapacity];

        System.arraycopy(m_chars, 0, chars, 0, m_index);
        m_chars = chars;
    }

    private void copyString(String str)
    {
        System.arraycopy(str.toCharArray(), 0, m_chars, m_index, str.length());
        m_index += str.length();
    }

    private boolean checkCapacityIfNecessary(String str)
    {
        return m_index + str.length() > m_chars.length;
    }

    public CSDStringBuilder()
    {
        m_chars = new char[DEFAULT_CAPACITY];
    }

    public CSDStringBuilder(int capacity)
    {
        //...
        m_chars = new char[capacity];
    }

    public CSDStringBuilder(String str)
    {
        m_chars = new char[str.length() + DEFAULT_CAPACITY];
        copyString(str);
    }

    public CSDStringBuilder append(String str) //O(N)
    {
        if (checkCapacityIfNecessary(str))
            allocate(m_chars.length + str.length() + DEFAULT_CAPACITY);

        copyString(str);

        return this;
    }

    public CSDStringBuilder append(int val)
    {
        return append(String.valueOf(val));
    }

    public CSDStringBuilder append(long val)
    {
        return append(String.valueOf(val));
    }

    public CSDStringBuilder append(double val)
    {
        return append(String.valueOf(val));
    }

    public CSDStringBuilder append(float val)
    {
        return append(String.valueOf(val));
    }

    public CSDStringBuilder append(char ch)
    {
        return append(String.valueOf(ch));
    }

    public CSDStringBuilder append(char [] str)
    {
        return append(str, 0, str.length);
    }

    public CSDStringBuilder append(char [] str, int offset, int len)
    {
        throw new UnsupportedOperationException("TODO:!...");
    }

    public int capacity()
    {
        return m_chars.length;
    }

    public CSDStringBuilder insert(int offset, String str)
    {
        throw new UnsupportedOperationException("TODO:!...");
    }

    public CSDStringBuilder insert(int offset, int value)
    {
        throw new UnsupportedOperationException("TODO:!...");
    }

    public CSDStringBuilder insert(int offset, long value)
    {
        throw new UnsupportedOperationException("TODO:!...");
    }

    public CSDStringBuilder insert(int offset, double value)
    {
        throw new UnsupportedOperationException("TODO:!...");
    }

    public CSDStringBuilder insert(int offset, float value)
    {
        throw new UnsupportedOperationException("TODO:!...");
    }

    public CSDStringBuilder insert(int offset, char value)
    {
        throw new UnsupportedOperationException("TODO:!...");
    }

    public CSDStringBuilder insert(int offset, char [] str)
    {
        return insert(offset, str, 0, str.length);
    }

    public CSDStringBuilder insert(int offset, char [] str, int srcOffset, int len)
    {
        throw new UnsupportedOperationException("TODO:!...");
    }

    public int length()
    {
        return m_index;
    }

    public StringBuilder reverse()
    {
        throw new UnsupportedOperationException("TODO:!...");
    }

    public String substring(int start)
    {
        throw new UnsupportedOperationException("TODO:!...");
    }

    public String substring(int start, int end)
    {
        throw new UnsupportedOperationException("TODO:!...");
    }

    public String toString()
    {
        return String.valueOf(m_chars, 0, m_index);
    }
}
