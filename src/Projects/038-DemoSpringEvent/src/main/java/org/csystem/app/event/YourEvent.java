
package org.csystem.app.event;


import lombok.Getter;
import lombok.experimental.Accessors;
import org.csystem.app.event.data.YourEventData;
import org.springframework.context.ApplicationEvent;

@Getter
public class YourEvent extends ApplicationEvent {
    @Accessors(prefix = "m_")
    private final YourEventData m_yourEventData;

    public YourEvent(Object source, YourEventData yourEventData)
    {
        super(source);
        m_yourEventData = yourEventData;
    }
}
