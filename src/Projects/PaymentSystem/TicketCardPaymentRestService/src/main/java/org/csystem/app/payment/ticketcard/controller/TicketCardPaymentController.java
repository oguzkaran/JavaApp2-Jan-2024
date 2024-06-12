package org.csystem.app.payment.ticketcard.controller;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.ticketcard.dto.PaymentSaveInfoDTO;
import org.csystem.app.payment.ticketcard.service.TicketCardPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment/card/ticket")
@Slf4j
public class TicketCardPaymentController {
    private final TicketCardPaymentService m_ticketCardPaymentService;

    public TicketCardPaymentController(TicketCardPaymentService ticketCardPaymentService)
    {
        m_ticketCardPaymentService = ticketCardPaymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<PaymentSaveInfoDTO> pay(@RequestBody PaymentSaveInfoDTO paymentSaveInfoDTO)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @GetMapping("/report/today")
    public ResponseEntity<Object> todayPayments()
    {
        throw new UnsupportedOperationException("Not yet implemented!....");
    }
}
