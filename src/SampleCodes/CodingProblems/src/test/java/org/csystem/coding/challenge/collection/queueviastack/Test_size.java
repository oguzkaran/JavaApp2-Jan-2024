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

@RunWith(Parameterized.class)
public class Test_size {
    private final LinkedList<String> m_linkedList;
    private final QueueViaStack<String> m_queue;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        return StringDataFactory.getData();
    }

    public Test_size(List<String> list)
    {
        m_linkedList = new LinkedList<>();
        list.forEach(m_linkedList::addLast);
        m_queue = new QueueViaStack<>();
        m_linkedList.forEach(m_queue::enqueue);
    }

    @Test
    public void test_size()
    {
        for (int i = 0; i < m_linkedList.size(); ++i) {
            m_linkedList.pollFirst();
            m_queue.dequeue();

            Assert.assertEquals(m_linkedList.size(), m_queue.size());
        }
    }
}
