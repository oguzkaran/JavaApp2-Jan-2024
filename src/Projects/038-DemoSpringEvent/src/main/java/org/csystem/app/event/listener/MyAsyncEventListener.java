package org.csystem.app.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.event.MyAsyncEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyAsyncEventListener {
    @EventListener
    @Async
    public void onApplicationEvent(MyAsyncEvent event)
    {
        log.info("MyAsyncEvent processing -> Message:{}", event.getMessage());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("MyAsyncEvent processed -> Message:{}", event.getMessage());
    }
}
