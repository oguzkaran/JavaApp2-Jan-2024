package org.csystem.app.payment.service;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.dto.PaymentDto;
import org.csystem.app.payment.dto.PaymentListDto;
import org.csystem.app.payment.dto.PaymentResultDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@Slf4j
public class PaymentService {
    //Inject repository or facade
    public PaymentListDto getAllPayments()
    {
        log.info("Get all payments");
        var list = new ArrayList<PaymentDto>();

        list.add(PaymentDto.builder().cardNumber("134").description("Food").cash(100).date(LocalDateTime.now()).build());

        return PaymentListDto.builder().payments(list).build();
    }

    public PaymentResultDto pay(PaymentDto paymentDto)
    {
        log.info("Paid successfully via {}", paymentDto.getCardNumber());

        return PaymentResultDto.builder().cardNumber(paymentDto.getCardNumber()).description("Paid successfully via %s".formatted(paymentDto.getCardNumber())).build();
    }
}
