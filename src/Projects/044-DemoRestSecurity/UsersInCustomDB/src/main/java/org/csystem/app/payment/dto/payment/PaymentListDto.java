package org.csystem.app.payment.dto.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
public class PaymentListDto {
    private List<PaymentDto> m_payments;
}
