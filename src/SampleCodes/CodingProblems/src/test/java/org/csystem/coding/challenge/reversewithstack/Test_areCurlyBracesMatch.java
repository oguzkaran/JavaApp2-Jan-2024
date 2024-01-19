package org.csystem.coding.challenge.reversewithstack;

import org.csystem.coding.challenge.CodingChallenge;
import org.junit.Assert;
import org.junit.Test;

public class Test_areCurlyBracesMatch {

    @Test
    public void test_areCurlyBracesMatchTrue1()
    {
        Assert.assertTrue(CodingChallenge.areCurlyBracesMatch("{{{}}}{}{{}}"));
    }

    @Test
    public void test_areCurlyBracesMatchTrue2()
    {
        Assert.assertTrue(CodingChallenge.areCurlyBracesMatch("{{{}}}"));
    }

    @Test
    public void test_areCurlyBracesMatchTrue3()
    {
        Assert.assertTrue(CodingChallenge.areCurlyBracesMatch("{}"));
    }

    @Test
    public void test_areCurlyBracesMatchFalse1()
    {
        Assert.assertFalse(CodingChallenge.areCurlyBracesMatch("}"));
    }

    @Test
    public void test_areCurlyBracesMatchFalse2()
    {
        Assert.assertFalse(CodingChallenge.areCurlyBracesMatch("{"));
    }

    @Test
    public void test_areCurlyBracesMatchFalse3()
    {
        Assert.assertFalse(CodingChallenge.areCurlyBracesMatch("}{{{}}}"));
    }

    @Test
    public void test_areCurlyBracesMatchFalse4()
    {
        Assert.assertFalse(CodingChallenge.areCurlyBracesMatch("{{{}}}{"));
    }
}
