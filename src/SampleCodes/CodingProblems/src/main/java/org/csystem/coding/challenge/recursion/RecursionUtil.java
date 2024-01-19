package org.csystem.coding.challenge.recursion;

import org.csystem.util.console.Console;

public final class RecursionUtil {
    private static int gcdRecur(int a, int b)
    {
        return b == 0 ? a : gcdRecur(b, a % b);
    }

    private static int fibonacciNumberRecur(int n)
    {
        if (n <= 2)
            return n - 1;

        return fibonacciNumberRecur(n - 1) + fibonacciNumberRecur(n - 2);
    }

    private static void reversedRecur(char [] c, int left, int right)
    {
        if (left >= right)
            return;

        char temp;

        temp = c[left];
        c[left] = c[right];
        c[right] = temp;

        reversedRecur(c, left + 1, right - 1);
    }

    private static void writeNumberRecur(int val, int radix)
    {
        if (val / radix != 0)
            writeNumberRecur(val / radix, radix);

        System.out.write((char)((val % radix >= 10 ? 'A'- 10 : '0') + val % radix));
    }

    private static void writeReverseRecur(String s, int i)
    {
        if (i == s.length())
            return;

        writeReverseRecur(s, i + 1);
        System.out.write(s.charAt(i));
    }

    private RecursionUtil()
    {
    }

    public static int gcd(int a, int b)
    {
        return gcdRecur(Math.abs(a), Math.abs(b));
    }

    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        return n * factorial(n - 1);
    }

    public static int fibonacciNumber(int n)
    {
        if (n <= 0)
            return  -1;

        return fibonacciNumberRecur(n);
    }

    public static String reversed(String s)
    {
        char [] c = s.toCharArray();

        reversedRecur(c, 0, c.length - 1);

        return String.valueOf(c);
    }

    public static void writeCollatz(int n)
    {
        Console.writeLine(n);

        if (n == 1)
            return;

        writeCollatz(n % 2 == 0 ? n / 2 : 3 * n + 1);
    }

    public static void writeNumber(int val)
    {
        writeNumber(val, 10);
    }

    public static void writeNumber(int val, int radix)
    {
        if (val < 0)
            System.out.write('-');

        writeNumberRecur(val, radix);
        System.out.flush();
    }

    public static void writeReverse(String s)
    {
        writeReverseRecur(s, 0);
        System.out.flush();
    }
}
