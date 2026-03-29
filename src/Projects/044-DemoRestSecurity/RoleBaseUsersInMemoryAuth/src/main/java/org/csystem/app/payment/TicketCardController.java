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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@RequestBody PaymentDto paymentDto)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //...
}
