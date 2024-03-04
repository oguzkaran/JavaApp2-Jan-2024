/*----------------------------------------------------------------------
	FILE        : EndianConverter.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 21.04.2023

	EndianConverter class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.net;

public final class EndianConverter {
    private EndianConverter()
    {
    }

    public static short toLittleEndian(short value)
    {
        return BitConverter.toLittleEndian(value);
    }

    public static short toBigEndian(short value)
    {
        return BitConverter.toBigEndian(value);
    }

    public static int toLittleEndian(int value)
    {
        return BitConverter.toLittleEndian(value);
    }

    public static int toBigEndian(int value)
    {
        return BitConverter.toBigEndian(value);
    }

    public static long toLittleEndian(long value)
    {
        return BitConverter.toLittleEndian(value);
    }

    public static long toBigEndian(long value)
    {
        return BitConverter.toBigEndian(value);
    }
}
