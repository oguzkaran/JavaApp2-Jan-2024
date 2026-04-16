package org.csystem.app.payment.dto.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
public class PaymentResultDto {
    private String m_cardNumber;
    private String m_description;
}
