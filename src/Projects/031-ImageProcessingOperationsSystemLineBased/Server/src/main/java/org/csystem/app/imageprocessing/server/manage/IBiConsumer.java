package org.csystem.app.imageprocessing.server.manage;

public interface IBiConsumer<T, U> {
    void accept(T t, U u) throws Exception;
}
