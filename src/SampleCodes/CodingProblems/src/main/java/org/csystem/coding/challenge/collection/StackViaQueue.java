package org.csystem.coding.challenge.collection;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

public class StackViaQueue<E> {
    private final Queue<E> m_queue1;
    private final Queue<E> m_queue2;
    private E m_peek;
    private int m_size;

    private static <E> E switchQueues(Queue<E> srcQueue, Queue<E> destQueue)
    {
        while (srcQueue.size() > 1)
            destQueue.add(srcQueue.poll());

        return srcQueue.poll();
    }

    public StackViaQueue()
    {
        m_queue1 = new ArrayDeque<>();
        m_queue2 = new ArrayDeque<>();
    }

    public void push(E item)
    {
        if (m_queue1.isEmpty()) {
            if (m_peek != null)
                m_queue2.add(m_peek);
            m_queue2.add(item);
        }
        else {
            if (m_peek != null)
                m_queue1.add(m_peek);
            m_queue1.add(item);
        }
        ++m_size;
        m_peek = null;
    }

    public E pop()
    {
        if (m_size == 0)
            throw new EmptyStackException();

        E result;

        if (m_peek != null) {
            result = m_peek;
            m_peek = null;
        }
        else
            result = m_queue1.isEmpty() ? switchQueues(m_queue2, m_queue1) : switchQueues(m_queue1, m_queue2);

        --m_size;
        return result;
    }

    public E peek()
    {
        if (m_size == 0)
            throw new EmptyStackException();

        if (m_peek == null)
            m_peek = m_queue1.isEmpty() ? switchQueues(m_queue2, m_queue1) : switchQueues(m_queue1, m_queue2);

        return m_peek;
    }

    public int size()
    {
        return m_size;
    }
}
