package org.csystem.app;

public class ThreadParam {
    private final int m_count;
    private final int m_min;
    private final int m_bound;

    private long m_result;

    public ThreadParam(int count, int min, int bound)
    {
        m_count = count;
        m_min = min;
        m_bound = bound;
    }

    public int getCount()
    {
        return m_count;
    }

    public int getMin()
    {
        return m_min;
    }

    public int getBound()
    {
        return m_bound;
    }

    public long getResult()
    {
        return m_result;
    }

    public void add(long value)
    {
        m_result += value;
    }

    //...
}
