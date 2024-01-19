package org.csystem.coding.challenge.collection.stackviaqueue;

import org.csystem.coding.challenge.collection.StackViaQueue;
import org.csystem.factory.StringDataFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

@RunWith(Parameterized.class)
public class Test_pop_peek {
    private final Stack<String> m_stack;
    private final StackViaQueue<String> m_stackViaQueue;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        return StringDataFactory.getData();
    }

    public Test_pop_peek(List<String> list)
    {
        m_stack = new Stack<>();
        list.forEach(m_stack::push);
        m_stackViaQueue = new StackViaQueue<>();
        m_stack.forEach(m_stackViaQueue::push);
    }

    @Test
    public void test_pop_peek()
    {
        for (int i = 0; i < m_stackViaQueue.size(); ++i) {
            m_stack.peek();
            m_stackViaQueue.peek();
            var expected = m_stack.pop();
            var actual = m_stackViaQueue.pop();

            Assert.assertEquals(expected, actual);
        }
    }
}
