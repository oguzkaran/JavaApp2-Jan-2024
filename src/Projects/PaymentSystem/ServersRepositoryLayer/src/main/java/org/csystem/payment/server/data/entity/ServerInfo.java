package org.csystem.payment.server.data.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ServerInfo {
    @Accessors(prefix = "m_")
    private String m_id;

    @Accessors(prefix = "m_")
    private String m_communicationInfo;

    @Accessors(prefix = "m_")
    private String m_connectionInfo;

    @Accessors(prefix = "m_")
    private LocalDateTime m_registerDateTime;
}
