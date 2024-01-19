package org.csystem.coding.challenge.collection;

import java.util.OptionalInt;
import java.util.Stack;

public class MinSubStack extends Stack<Integer> {
    private final Stack<Integer> m_minStack;
    private final int m_size;

    public MinSubStack(int size)
    {
        m_minStack = new Stack<>();
        m_size = size;
    }

    @Override
    public Integer push(Integer val)
    {
        if (this.size() == m_size) // For O(1) complexity, may be unnessary
            return null;

        var minOpt = this.min();

        if (minOpt.isPresent()) {
            if (val <= minOpt.getAsInt())
                m_minStack.push(val);
        }
        else
            m_minStack.push(val);

        return super.push(val);
    }

    @Override
    public Integer pop()
    {
        var result = super.pop();

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
