package org.csystem.coding.challenge.collection.queueviastack;

import org.csystem.coding.challenge.collection.QueueViaStack;
import org.csystem.factory.StringDataFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@RunWith(Parameterized.class)
public class Test_enqueue_dequeue {
    private final LinkedList<String> m_linkedList;
    private final QueueViaStack<String> m_queue;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        return StringDataFactory.getData();
    }

    public Test_enqueue_dequeue(List<String> list)
    {
        m_linkedList = new LinkedList<>();
        list.forEach(m_linkedList::addLast);
        m_queue = new QueueViaStack<>();
        m_linkedList.forEach(m_queue::enqueue);
    }

    @Test
    public void test_enqueue_deque()
    {
        for (int i = 0; i < m_linkedList.size(); ++i) {
            var expected = m_linkedList.pollFirst();
            var actual = m_queue.dequeue();

            Assert.assertEquals(expected, actual);
        }
    }
}
