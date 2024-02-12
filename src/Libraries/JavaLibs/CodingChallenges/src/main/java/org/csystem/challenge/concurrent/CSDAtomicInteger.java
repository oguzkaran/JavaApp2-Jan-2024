package org.csystem.challenge.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class CSDAtomicInteger {
    private int m_value;

    public CSDAtomicInteger()
    {
        this(0);
    }

    public CSDAtomicInteger(int value)
    {
        m_value = value;
    }

    public synchronized int getAndIncrement()
    {
        return getAndAdd(1);
    }

    public synchronized int getAndAdd(int value)
    {
        var val = m_value;

        m_value += value;

        return val;
    }

    public synchronized int get()
    {
        return m_value;
    }

    //...
}
