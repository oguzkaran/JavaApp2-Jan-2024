package org.csystem.coding.challenge.collection;

import java.util.OptionalInt;
import java.util.Stack;

public class MinWrapperStack {
    private final Stack<Integer> m_minStack;
    private final Stack<Integer> m_stack;
    private final int m_size;

    public MinWrapperStack(int size)
    {
        m_minStack = new Stack<>();
        m_stack = new Stack<>();
        m_size = size;
    }

    public OptionalInt push(Integer val)
    {
        if (m_stack.size() == m_size) // For O(1) complexity, may be unnessary
            return OptionalInt.empty();

        var minOpt = this.min();

        if (minOpt.isPresent()) {
            if (val <= minOpt.getAsInt())
                m_minStack.push(val);
        }
        else
            m_minStack.push(val);

        return OptionalInt.of(m_stack.push(val));
    }

    public int pop()
    {
        var result = m_stack.pop();

        var minOpt = this.min();

        if (minOpt.isPresent() && result == minOpt.getAsInt())
            m_minStack.pop();

        return result;
    }

    public OptionalInt min()
    {
        return m_minStack.empty() ? OptionalInt.empty() : OptionalInt.of(m_minStack.peek());
    }
}
