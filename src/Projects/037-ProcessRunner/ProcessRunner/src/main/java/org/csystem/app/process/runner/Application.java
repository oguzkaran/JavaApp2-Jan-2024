package org.csystem.app.process.runner;


import com.karandev.io.util.console.Console;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthGreaterOrEqual;

class Application {
    private static void runProcess(String outputPath, String errorPath, String []commands)
    {
        try {
            var processBuilder = new ProcessBuilder(commands);
            var outputFile = new File(outputPath);
            var errorFile = new File(errorPath);
            processBuilder.redirectOutput(new File(outputPath));
            processBuilder.redirectError(new File(errorPath));

            var process = processBuilder.start();

            process.waitFor();
            Console.writeLine("Exit value:%d", process.exitValue());

            Files.lines(outputFile.toPath()).forEach(Console::writeLine);
            Files.lines(errorFile.toPath()).forEach(Console::writeLine);
        }
        catch (IOException ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Internal Error occurred:%s", ex.getMessage());
        }


    }

    public static void run(String[] args)
    {
        checkLengthGreaterOrEqual(args.length, 3, "usage: java -jar ProcessRunnerApp-1.0.0.jar <output path> <error path> <program> [argument list]");

        runProcess(args[0], args[1], Arrays.copyOfRange(args, 2, args.length));
    }
}
