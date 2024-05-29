package org.csystem.app.process.runner;


import com.karandev.io.util.console.Console;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthGreaterOrEqual;
import static org.csystem.util.process.ProcessUtil.startProcess;

class Application {
    private static void processBuilderActionCallback(ProcessBuilder processBuilder, File outFile, File errorFile)
    {
        processBuilder.redirectOutput(outFile);
        processBuilder.redirectError(errorFile);
    }

    private static void exitActionCallback(Process process, File outFile, File errorFile)
    {
        try {
            Console.writeLine("Exit value:%d", process.exitValue());
            Files.lines(outFile.toPath()).forEach(Console::writeLine);
            Files.lines(errorFile.toPath()).forEach(Console::writeLine);
        }
        catch (IOException ex) {
            Console.Error.writeLine("Internal Error occurred:%s", ex.getMessage());
        }
    }

    private static void exceptionActionCallback(Throwable ex)
    {
        Console.Error.writeLine("Exception occurred:%s", ex.getMessage());
    }

    private static void runProcess(String outputPath, String errorPath, String []commands)
    {
        try {
            var outFile = new File(outputPath);
            var errFile = new File(errorPath);

            startProcess(p -> processBuilderActionCallback(p, outFile, errFile),
                    p -> exitActionCallback(p, outFile, errFile), Application::exceptionActionCallback, commands);
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Process start error occurred:%s", ex.getMessage());
        }
    }

    public static void run(String[] args)
    {
        checkLengthGreaterOrEqual(args.length, 3, "usage: java -jar ProcessRunnerApp-1.0.0.jar <output path> <error path> <program> [argument list]");

        runProcess(args[0], args[1], Arrays.copyOfRange(args, 2, args.length));
    }
}
