package org.csystem.app.payment;

import org.csystem.app.payment.dto.PaymentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment/card/ticket")
public class TicketCardController {
    //...
    @GetMapping("/all")
    public String getAllPayments()
    {
        return "Get all payments";
    }

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@RequestBody PaymentDto paymentDto)
    {
        return ResponseEntity.ok("Paid successfully via %s".formatted(paymentDto.getCardNumber()));
    }

    //...
}

