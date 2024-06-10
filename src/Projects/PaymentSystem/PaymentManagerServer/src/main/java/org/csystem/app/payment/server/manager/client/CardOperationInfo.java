package org.csystem.app.payment.server.manager.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.function.Consumer;

@Getter
@Setter
@EqualsAndHashCode(exclude = "m_clientInfoConsumer")
public class CardOperationInfo {
    @Accessors(prefix = "m_") private int m_type;
    @Accessors(prefix = "m_") private Consumer<ClientInfo> m_clientInfoConsumer;

    public CardOperationInfo(int type)
    {
        this(type, null);
    }

    public CardOperationInfo(int type, Consumer<ClientInfo> clientInfoConsumer)
    {
        this.m_type = type;
        this.m_clientInfoConsumer = clientInfoConsumer;
    }

    @Override
    public String toString()
        {
            return "%s".formatted(m_type);
        }
    }
