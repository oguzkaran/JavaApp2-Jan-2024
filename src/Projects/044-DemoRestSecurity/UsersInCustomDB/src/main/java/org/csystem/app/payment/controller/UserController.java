package org.csystem.app.payment.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.dto.user.RegisterDto;
import org.csystem.app.payment.dto.user.UpdatePasswordDto;
import org.csystem.app.payment.dto.user.UserDto;
import org.csystem.app.payment.dto.user.UserUpdateDto;
import org.csystem.app.payment.service.PaymentUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Scope("prototype")
@RequestMapping("/payment/users")
@Slf4j
@AllArgsConstructor
@Accessors(prefix = "m_")
public class UserController {
    private final PaymentUserService m_paymentUserService;
    private final HttpServletRequest m_request;

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
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Boolean> updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto)
    {
        log.info("Username:{}", m_request.getUserPrincipal().getName());

        return m_paymentUserService.updatePassword(updatePasswordDto) ? ResponseEntity.ok(true) : ResponseEntity.ok(false);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDto> register(@RequestBody RegisterDto registerDto)
    {
        log.info("Register user {}", registerDto.getUsername());

        return ResponseEntity.ok(m_paymentUserService.register(registerDto));
    }

    //...
}

