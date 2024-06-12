package org.csystem.app.payment.ticketcard.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PaymentInfoDTO {
    @Accessors(prefix = "m_")
    private double m_price;

    @Accessors(prefix = "m_")
    private String m_description;
}
