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
public class YourEventListener  {
    @EventListener
    public void onApplicationEvent(YourEvent event)
    {
        var count = event.getYourEventData().getCount();

        log.info("YourEvent processing -> Count:{}", count);
        var random = new Random();

        event.getYourEventData().setNumbers(IntStream.generate(() -> random.nextInt(100))
                .limit(count)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("-")));

        log.info("Numbers:{}", event.getYourEventData().getNumbers());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("YourEvent processed -> Count:{}", count);
    }
}
