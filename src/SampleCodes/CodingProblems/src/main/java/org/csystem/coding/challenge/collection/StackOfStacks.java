package org.csystem.coding.challenge.collection;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class StackOfStacks<E> {
    private final int m_stackSize;
    private final LinkedList<Stack<E>> m_stackList;

    private void removeLastStack()
    {
        if (m_stackList.getLast().isEmpty())
            m_stackList.removeLast();
    }

    private void shift(int stackIndex)
    {
        var sizem1 = m_stackList.size() - 1;

        for (int i = stackIndex; i < sizem1; ++i) {
            var curStack = m_stackList.get(i);
            var nextStack = m_stackList.get(i + 1);

            curStack.push(nextStack.remove(0));
        }
    }

    public StackOfStacks(int stackSize)
    {
        m_stackSize = stackSize;
        m_stackList = new LinkedList<>();
    }

    public boolean empty()
    {
        return m_stackList.isEmpty();
    }

    public void push(E item) //~O(1)
    {
        Stack<E> stack;

        if (m_stackList.isEmpty() || (stack = m_stackList.getLast()).size() >= m_stackSize) {
            stack = new Stack<>();
            stack.push(item);
            m_stackList.add(stack);
        }
        else
            stack.push(item);
    }

    public E pop() //O(1)
    {
        if (m_stackList.isEmpty())
            throw new EmptyStackException();

        var stack = m_stackList.getLast();

        E item = stack.pop();

        removeLastStack();

        return item;
    }

    public E popAt(int stackIndex) //O(n)
    {
        E item = m_stackList.get(stackIndex).pop();

        shift(stackIndex);
        removeLastStack();

        return item;
    }

    public int size()
    {
        return m_stackList.size();
    }
    //...
}
