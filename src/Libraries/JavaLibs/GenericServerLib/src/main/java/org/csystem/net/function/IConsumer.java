package org.csystem.net.function;

import java.net.Socket;

@FunctionalInterface
public interface IConsumer<T> {
    void accept(T t) throws Exception;
}
