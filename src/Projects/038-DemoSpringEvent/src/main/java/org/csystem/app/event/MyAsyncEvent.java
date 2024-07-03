
package org.csystem.app.event;


import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.context.ApplicationEvent;

@Getter
public class MyAsyncEvent extends ApplicationEvent {
    @Accessors(prefix = "m_")
    private final String m_message;
    public MyAsyncEvent(Object source, String message)
    {
        super(source);
        m_message = message;
    }
}
