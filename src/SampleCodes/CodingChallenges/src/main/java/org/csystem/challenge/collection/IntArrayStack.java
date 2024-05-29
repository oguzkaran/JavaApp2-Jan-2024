package org.csystem.challenge.collection;

/**
 *
 * Fixed stack that stores int values. Stack capacity does not grow. It is fixed
 * @author JavaApp2-Jan-2024 group
 */
public class IntArrayStack {
    private final int [] m_values;
    private int m_index;

    /**
     * Creates a fixed stack
     * @param count capacity of the stack
     */
    public IntArrayStack(int count)
    {
        m_values = new int[count];
    }

    /**
     * Pushes a value to the stack if available
     * @param value for push
     * @return true if stack is available, false if stack full
     */
    public boolean push(int value)
    {
        var result = m_index != m_values.length;

        if (result)
            m_values[m_index++] = value;

        return result;
    }

    /**
     * Peek the last element from stack
     * @return last element from stack, zero if stack is empty
     */
    public int peek()
    {
        return m_index != 0 ? m_values[m_index - 1] : 0;
    }

    /**
     * Pops a last value from stack if stack is not empty
     * @return true if stack is available, false if stack is empty
     */
    public boolean pop()
    {
        var result = m_index != 0;

        if (m_index != 0)
            --m_index;

        return result;
    }

    /**
     *  Check if stack is empty
     * @return true if stack is empty, otherwise false
     */
    public boolean isEmpty()
    {
        return m_index == 0;
    }

    /**
     * Gets the size of the elements int the stack
     *
     * @return size of the elements int the stack
     */
    public int size()
    {
        return m_index;
    }

    /**
     * Gets the capacity of the elements int the stack
     *
     * @return capacity of the elements int the stack
     */
    public int capacity()
    {
        return m_values.length;
    }
}
