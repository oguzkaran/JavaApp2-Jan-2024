package org.csystem.coding.challenge.reversewithstack;

import org.csystem.coding.challenge.CodingChallenge;
import org.csystem.factory.StringDataFactory;
import org.csystem.util.string.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

@RunWith(Parameterized.class)
public class Test_reverseWithStack {
    private final String m_str;

    @Parameterized.Parameters
    public static Collection<String> createData()
    {
        return StringDataFactory.getStringCollection("testdata/strings.txt");
    }

    public Test_reverseWithStack(String str)
    {
        m_str = str;
    }

    @Test
    public void test_reverseWithStack()
    {
        Assert.assertEquals(StringUtil.reverse(m_str), CodingChallenge.reverseWithStack(m_str));
    }
}
