package org.csystem.app.payment.controller;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.dto.user.UserDto;
import org.csystem.app.payment.dto.user.UserUpdateDto;
import org.csystem.app.payment.dto.user.UserUpdatePasswordDto;
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
    public void updateUser(@RequestBody UserUpdateDto userUpdateDto)
    {
        m_paymentUserService.updateUser(userUpdateDto);
    }

    @PutMapping("/password")
    @PreAuthorize("hasRole('ADMIN') and hasRole('USER')")
    public void updatePassword(@RequestBody UserUpdatePasswordDto userUpdatePasswordDto)
    {
        throw new UnsupportedOperationException("TODO");
    }

    //...
}

