package org.csystem.app;

import java.util.LinkedList;

class Application {
    public static void run(String[] args)
    {
        var pc = new ProducerConsumer(new LinkedList<>());

        pc.run();
    }
}

