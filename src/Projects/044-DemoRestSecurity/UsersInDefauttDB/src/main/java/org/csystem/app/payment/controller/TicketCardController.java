package org.csystem.app.payment.controller;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.dto.PaymentDto;
import org.csystem.app.payment.dto.PaymentListDto;
import org.csystem.app.payment.dto.PaymentResultDto;
import org.csystem.app.payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment/card/ticket")
@Slf4j
@AllArgsConstructor
@Accessors(prefix = "m_")
public class TicketCardController {
    private final PaymentService m_paymentService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('VIEWER')")
    public PaymentListDto getAllPayments()
    {
        log.info("Authenticated to get all payments");
        return m_paymentService.getAllPayments();
    }

    @PostMapping("/pay")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PaymentResultDto> pay(@RequestBody PaymentDto paymentDto)
    {
        log.info("Authenticated to payment {}", paymentDto.getCardNumber());

        return ResponseEntity.ok(m_paymentService.pay(paymentDto));
    }

    //...
}

