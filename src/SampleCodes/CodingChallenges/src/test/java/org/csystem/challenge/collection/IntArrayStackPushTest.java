package org.csystem.challenge.collection;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IntArrayStackPushTest {
    private final IntArrayStack m_stack = new IntArrayStack(10);

    @Test
    public void testSize()
    {
        var size = 5;

        for (var i = 0; i < size; ++i)
            m_stack.push(i * 10);

        assertEquals(size, m_stack.size());
    }

    @Test
    public void returnValueTrueTest()
    {
        assertTrue(m_stack.push(10));
    }

    @Test
    public void returnValueFalseTest()
    {
        var size = 10;

        for (var i = 0; i < size; ++i)
            m_stack.push(i * 10);

        assertFalse(m_stack.push(10));
    }
}
