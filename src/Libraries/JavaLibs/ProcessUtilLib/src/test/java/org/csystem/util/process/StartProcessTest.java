package org.csystem.util.process;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static org.junit.jupiter.api.Assertions.*;

@Disabled("Written by Bartu Çankaya")
class StartProcessTest {
    @Test
    void testStartProcessExitAction() {
        ProcessUtil.startProcess(
                1000, MILLISECONDS,
                processBuilder -> {},
                process -> assertEquals(0, process.exitValue()),
                process -> fail(),
                ex -> fail(),
                ex -> fail(),
                "java", "-version"
        );
    }

    @Test
    void testStartProcessElapsedAction() {
        ProcessUtil.startProcess(
                1, NANOSECONDS,
                processBuilder -> {},
                process -> fail(),
                process -> assertTrue(true),
                ex -> fail(),
                ex -> fail(),
                "java", "-version"
        );
    }

    private void interruptThreadCallback(Thread thread)
    {
        try {
            Thread.sleep(1000);
            thread.interrupt();
        }
        catch (InterruptedException ignore) {

        }
    }

    @Test
    void testStartProcessInterruptActionBeforeWaitFor() {
        Thread.currentThread().interrupt();

        ProcessUtil.startProcess(
                1000, MILLISECONDS,
                processBuilder -> {},
                process -> fail(),
                process -> fail(),
                ex -> assertInstanceOf(InterruptedException.class, ex),
                ex -> fail(),
                "java", "-version"
        );
    }

    @Test
    void testStartProcessInterruptActionAfterWaitFor() {
        var thread = Thread.currentThread();

        new Thread(() -> interruptThreadCallback(thread)).start();

        ProcessUtil.startProcess(
                1000, MILLISECONDS,
                processBuilder -> {},
                process -> fail(),
                process -> fail(),
                ex -> assertInstanceOf(InterruptedException.class, ex),
                ex -> fail(),
                "sleep", "3" //Application that takes few times to exit
        );
    }

    @Test
    void testStartProcessExceptionAction() {
        ProcessUtil.startProcess(
                1000, MILLISECONDS,
                processBuilder -> {
                    throw new UnsupportedOperationException();
                },
                process -> fail(),
                process -> fail(),
                ex -> fail(),
                ex -> assertInstanceOf(UnsupportedOperationException.class, ex),
                "java", "-version"
        );
    }
}