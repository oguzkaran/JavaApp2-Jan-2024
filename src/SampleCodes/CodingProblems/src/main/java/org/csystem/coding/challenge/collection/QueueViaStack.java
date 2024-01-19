package org.csystem.coding.challenge.collection;

import java.util.Stack;

public class QueueViaStack<E> {
    private final Stack<E> m_enqueueStack;
    private final Stack<E> m_dequeueStack;

    private void fillDequeueStack()
    {
        if (!m_dequeueStack.isEmpty())
            return;

        while (!m_enqueueStack.empty())
            m_dequeueStack.push(m_enqueueStack.pop());
    }

    public QueueViaStack()
    {
        m_enqueueStack = new Stack<>();
        m_dequeueStack = new Stack<>();
    }

    public void enqueue(E item)
    {
        m_enqueueStack.push(item);
    }


    public E dequeue()
    {
        fillDequeueStack();

        return m_dequeueStack.pop();
    }

    public E peek()
    {
        fillDequeueStack();

        return m_dequeueStack.peek();
    }

    public int size()
    {
        return m_enqueueStack.size() + m_dequeueStack.size();
    }
}
