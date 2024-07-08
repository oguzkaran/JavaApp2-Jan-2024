package org.csystem.payment.server.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Connection {

    @Accessors(prefix = "m_")
    private long m_id;

    @Accessors(prefix = "m_")
    private String m_connectionInfo;

    @Accessors(prefix = "m_")
    private String m_serverId;

    @Accessors(prefix = "m_")
    private LocalDateTime m_connectionTime;

    @Accessors(prefix = "m_")
    private LocalDateTime m_disconnectTime;
}
