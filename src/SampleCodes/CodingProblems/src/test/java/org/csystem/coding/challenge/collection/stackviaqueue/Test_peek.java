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
public class Test_peek {
    private final Stack<String> m_stack;
    private final StackViaQueue<String> m_stackViaQueue;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        return StringDataFactory.getData();
    }

    public Test_peek(List<String> list)
    {
        m_stack = new Stack<>();
        list.forEach(m_stack::push);
        m_stackViaQueue = new StackViaQueue<>();
        m_stack.forEach(m_stackViaQueue::push);
    }

    @Test
    public void test_peek()
    {
        for (int i = 0; i < m_stackViaQueue.size(); ++i) {
            var expected = m_stack.peek();
            var actual = m_stackViaQueue.peek();

            Assert.assertEquals(expected, actual);
            m_stack.pop();
            m_stackViaQueue.pop();
        }
    }
}
