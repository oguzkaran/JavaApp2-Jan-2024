package org.csystem.app.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event)
    {
        log.info("MyEvent processing -> Message:{}", event.getMessage());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("MyEvent processed -> Message:{}", event.getMessage());
    }
}
