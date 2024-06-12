package org.csystem.app.payment.ticketcard.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PaymentSaveInfoDTO {
    @Accessors(prefix = "m_")
    private double m_price;

    @Accessors(prefix = "m_")
    private String m_description;
}
