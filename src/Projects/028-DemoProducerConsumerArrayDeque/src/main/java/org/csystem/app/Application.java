package org.csystem.app;

import java.util.ArrayDeque;

class Application {
    public static void run(String[] args)
    {
        var pc = new ProducerConsumer(new ArrayDeque<>());

        pc.run();
    }
}

