package org.csystem.coding.challenge.collection.minwrapperstack;

import org.csystem.coding.challenge.collection.MinWrapperStack;
import org.csystem.factory.StringDataFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

@RunWith(Parameterized.class)
public class Test_push_pop {
    private final Stack<String> m_stack;
    private final MinWrapperStack m_minWrapperStack;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        return StringDataFactory.getData();
    }

    public Test_push_pop(List<String> list)
    {
        m_stack = new Stack<>();
        list.forEach(m_stack::push);
        m_minWrapperStack = new MinWrapperStack(m_stack.size());
        m_stack.forEach(s -> m_minWrapperStack.push(s.length()));
    }

    @Test
    public void test_push_pop()
    {
        for (int i = 0; i < m_stack.size(); ++i) {
            var expected = m_stack.pop().length();
            int actual = m_minWrapperStack.pop();

            Assert.assertEquals(expected, actual);
        }
    }
}
