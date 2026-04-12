package org.csystem.app.payment.controller;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.dto.PaymentResultDto;
import org.csystem.app.payment.dto.UserDto;
import org.csystem.app.payment.service.PaymentUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment/users")
@Slf4j
@AllArgsConstructor
@Accessors(prefix = "m_")
public class UserController {
    private final PaymentUserService m_paymentUserService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto)
    {
        log.info("Add user {}", userDto.getUsername());

        return ResponseEntity.ok(m_paymentUserService.addUser(userDto));
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto)
    {
        log.info("Add user {} with update user ", userDto.getUsername());

        return ResponseEntity.ok(m_paymentUserService.updateUser(userDto));
    }

    //...
}

