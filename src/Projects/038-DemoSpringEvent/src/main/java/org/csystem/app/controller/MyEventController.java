package org.csystem.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.event.MyAsyncEvent;
import org.csystem.app.event.MyEvent;
import org.csystem.app.event.YourEvent;
import org.csystem.app.event.data.YourEventData;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/api/trigger/event")
@Slf4j
public class MyEventController {
    private final ApplicationEventPublisher m_applicationEventPublisher;
    private final ExecutorService m_threadPool;

    public MyEventController(ApplicationEventPublisher applicationEventPublisher, ExecutorService threadPool)
    {
        m_applicationEventPublisher = applicationEventPublisher;
        m_threadPool = threadPool;
    }

    @GetMapping("my")
    public ResponseEntity<String> triggerMyEvent(@RequestParam(value = "msg") String message)
    {
        //...

        m_applicationEventPublisher.publishEvent(new MyEvent(this, message));

        log.info("Event published with message:{}", message);

        return ResponseEntity.ok(message);
    }

    @GetMapping("async/thread/my")
    public ResponseEntity<String> triggerMyEventAsyncViaThread(@RequestParam(value = "msg") String message)
    {
        //...
        m_threadPool.execute(() -> m_applicationEventPublisher.publishEvent(new MyEvent(this, message)));

        log.info("Async Event via thread published with message:{}", message);

        return ResponseEntity.ok(message);
    }

    @GetMapping("async/my")
    public ResponseEntity<String> triggerMyEventAsync(@RequestParam(value = "msg") String message)
    {
        //...
        m_applicationEventPublisher.publishEvent(new MyAsyncEvent(this, message));

        log.info("Async Event published with message:{}", message);

        return ResponseEntity.ok(message);
    }

    @GetMapping("your")
    public ResponseEntity<String> triggerYourEvent(@RequestParam String username, @RequestParam("cnt") int count)
    {
        //...
        var data = new YourEventData(username, count);

        m_applicationEventPublisher.publishEvent(new YourEvent(this, data));

        log.info("Event published with count:{}", count);

        return ResponseEntity.ok(data.getNumbers());
    }

    //...
}
