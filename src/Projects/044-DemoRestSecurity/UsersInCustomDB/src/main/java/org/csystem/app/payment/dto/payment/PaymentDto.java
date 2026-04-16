package org.csystem.app.payment.dto.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
public class PaymentDto {
    private String m_cardNumber;
    private String m_description;
    private double m_cash;
    private LocalDateTime m_date;
    //...
}
