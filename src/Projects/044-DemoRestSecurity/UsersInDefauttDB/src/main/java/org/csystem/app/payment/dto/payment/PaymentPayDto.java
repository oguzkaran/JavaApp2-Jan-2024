package org.csystem.app.payment.dto.payment;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m_")
public class PaymentPayDto {
    private String m_cardNumber;
    private String m_description;
    private double m_quantity;
    private double m_cash;
    private double m_balance;
}
