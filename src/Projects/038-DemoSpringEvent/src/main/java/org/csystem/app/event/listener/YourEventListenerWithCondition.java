package org.csystem.app.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.event.YourEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Slf4j
public class YourEventListenerWithCondition {
    @EventListener(condition = "#event.yourEventData.username.contains('admin')")
    public void listen(YourEvent event)
    {
        var count = event.getYourEventData().getCount();
        var username = event.getYourEventData().getUsername();

        log.info("YourEvent processing with condition -> Username::{}, Count:{}", username, count);
        var random = new Random();

        event.getYourEventData().setNumbers(IntStream.generate(() -> random.nextInt(100))
                .limit(count)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("-")));

        log.info("Numbers with condition:{}", event.getYourEventData().getNumbers());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("YourEvent processed with condition -> Username::{}, Count:{}", username, count);
    }
}
