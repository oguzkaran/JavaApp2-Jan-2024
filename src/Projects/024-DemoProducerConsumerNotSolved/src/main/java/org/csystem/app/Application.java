package org.csystem.app;

class Application {
    public static void run(String[] args)
    {
        var pc = new ProducerConsumer();

        pc.run();
    }
}

