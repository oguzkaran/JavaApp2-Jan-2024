/*----------------------------------------------------------------------
	FILE        : ProcessUtil.java
	AUTHOR      : JavaApp2-Jan-2024 Team
	LAST UPDATE : 29th May 2024

	Utility class for process operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.process;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public final class ProcessUtil {
    private ProcessUtil()
    {
    }

    private static void startProcessAsyncWaitCallback(long timeout, TimeUnit timeUnit,
                                                      Process process, Consumer<Process> exitAction,
                                                      Consumer<Process> elapsedBeforeExitAction,
                                                      Consumer<InterruptedException> interruptAction,
                                                      Consumer<Throwable> exceptionAction)
    {
        try {
            if (process.waitFor(timeout, timeUnit))
                exitAction.accept(process);
            else
                elapsedBeforeExitAction.accept(process);
        }
        catch (InterruptedException ex)  {
            interruptAction.accept(ex);
        }
        catch (Throwable ex) {
            exceptionAction.accept(ex);
        }
    }

    /**
     *
     * @param timeout Maximum wait timeout value
     * @param timeUnit Unit of timeout
     * @param builderAction
     * @param exitAction
     * @param elapsedBeforeExitAction
     * @param interruptAction
     * @param exceptionAction
     * @param commands
     */

    public static void startProcess(long timeout, TimeUnit timeUnit,
                                    Consumer<ProcessBuilder> builderAction,
                                    Consumer<Process> exitAction,
                                    Consumer<Process> elapsedBeforeExitAction,
                                    Consumer<InterruptedException> interruptAction,
                                    Consumer<Throwable> exceptionAction,
                                    String...commands)
    {
        try {
            var processBuilder = new ProcessBuilder(commands);

            builderAction.accept(processBuilder);
            var process = processBuilder.start();

            if (process.waitFor(timeout, timeUnit))
                exitAction.accept(process);
            else
                elapsedBeforeExitAction.accept(process);
        }
        catch (InterruptedException ex) {
            interruptAction.accept(ex);
        }
        catch (Throwable ex) {
            exceptionAction.accept(ex);
        }
    }

    /**
     *
     * @param builderAction
     * @param exitAction
     * @param exceptionAction
     * @param commands
     */

    public static void startProcess(Consumer<ProcessBuilder> builderAction,
                                    Consumer<Process> exitAction,
                                    Consumer<Throwable> exceptionAction,
                                    String...commands)
    {
        try {
            var processBuilder = new ProcessBuilder(commands);

            builderAction.accept(processBuilder);
            var process = processBuilder.start();

            process.waitFor();

            exitAction.accept(process);
        }
        catch (Throwable ex) {
            exceptionAction.accept(ex);
        }
    }

    /**
     *
     * @param timeout
     * @param timeUnit
     * @param builderAction
     * @param exitAction
     * @param exceptionAction
     * @param commands
     */
    public static void startProcess(long timeout, TimeUnit timeUnit,
                                    Consumer<ProcessBuilder> builderAction,
                                    Consumer<Process> exitAction,
                                    Consumer<Throwable> exceptionAction,
                                    String...commands)
    {
        try {
            var processBuilder = new ProcessBuilder(commands);

            builderAction.accept(processBuilder);
            var process = processBuilder.start();

            process.waitFor(timeout, timeUnit);
            exitAction.accept(process);
        }
        catch (Throwable ex) {
            exceptionAction.accept(ex);
        }
    }

    /**
     *
     * @param timeout
     * @param timeUnit
     * @param builderAction
     * @param exitAction
     * @param elapsedBeforeExitAction
     * @param interruptAction
     * @param exceptionAction
     * @param commands
     */
    public static void startProcessAsync(long timeout, TimeUnit timeUnit,
                                         Consumer<ProcessBuilder> builderAction,
                                         Consumer<Process> exitAction,
                                         Consumer<Process> elapsedBeforeExitAction,
                                         Consumer<InterruptedException> interruptAction,
                                         Consumer<Throwable> exceptionAction,
                                         String...commands)
    {
        try {
            var processBuilder = new ProcessBuilder(commands);

            builderAction.accept(processBuilder);
            var process = processBuilder.start();

            new Thread(() -> startProcessAsyncWaitCallback(timeout, timeUnit, process, exitAction, elapsedBeforeExitAction, interruptAction, exceptionAction))
                    .start();
        }
        catch (IOException ex) {
            exceptionAction.accept(ex);
        }
    }

    //...
}
