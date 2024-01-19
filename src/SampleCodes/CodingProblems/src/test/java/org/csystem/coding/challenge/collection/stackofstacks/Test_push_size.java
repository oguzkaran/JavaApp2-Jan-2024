package org.csystem.coding.challenge.collection.stackofstacks;

import org.csystem.coding.challenge.collection.StackOfStacks;
import org.csystem.factory.StringDataFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class Test_push_size {
    private static final int STACK_SIZE = 3;
    private final List<String> m_list;
    private final StackOfStacks<String> m_stackArrayList;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        return StringDataFactory.getData();
    }

    public Test_push_size(List<String> list)
    {
        m_list = list;
        m_stackArrayList = new StackOfStacks<>(STACK_SIZE);
        m_list.forEach(m_stackArrayList::push);
    }

    @Test
    public void test_push_size()
    {
        var expected = m_list.size() / STACK_SIZE + (m_list.size() % STACK_SIZE != 0 ? 1 : 0);
        var actual = m_stackArrayList.size();

        Assert.assertEquals(expected, actual);
    }
}
