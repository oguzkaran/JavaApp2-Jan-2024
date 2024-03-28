/*----------------------------------------------------------------------
	FILE        : CommandLineArgs.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 18.02.2024

	Utility class for command line arguments check

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.io.util.console;

public final class CommandLineArgs {
    private CommandLineArgs()
    {
    }

    public static void checkLengthEquals(int argsLen, int len, String message)
    {
        checkLengthEquals(argsLen, len, message, 1);
    }

    public static void checkLengthEquals(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen != len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }
    public static void checkLengthNotEquals(int argsLen, int len, String message)
    {
        checkLengthNotEquals(argsLen, len, message, 1);
    }

    public static void checkLengthNotEquals(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen == len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }

    public static void checkLengthGreater(int argsLen, int len, String message)
    {
        checkLengthGreater(argsLen, len, message, 1);
    }

    public static void checkLengthGreater(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen <= len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }

    public static void checkLengthGreaterOrEqual(int argsLen, int len, String message)
    {
        checkLengthGreaterOrEqual(argsLen, len, message, 1);
    }

    public static void checkLengthGreaterOrEqual(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen < len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }

    public static void checkLengthLess(int argsLen, int len, String message)
    {
        checkLengthLess(argsLen, len, message, 1);
    }

    public static void checkLengthLess(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen >= len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }

    public static void checkLengthLessOrEqual(int argsLen, int len, String message)
    {
        checkLengthLessOrEqual(argsLen, len, message, 1);
    }

    public static void checkLengthLessOrEqual(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen > len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }
}
