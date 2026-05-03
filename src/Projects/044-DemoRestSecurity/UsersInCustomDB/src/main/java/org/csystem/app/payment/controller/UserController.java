package org.csystem.app.payment.controller;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.dto.user.UserDto;
import org.csystem.app.payment.service.PaymentUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@Accessors(prefix = "m_")
@RestController
@RequestMapping("/payment/users")
@Scope("prototype")
public class UserController {
    private final PaymentUserService m_paymentUserService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto)
    {
        log.info("Add user {}", userDto.getUsername());

        return ResponseEntity.ok(m_paymentUserService.addUser(userDto));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> getUser(@RequestParam(name = "name") String username)
    {
        return m_paymentUserService.findByUsername(username).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void updateUser(@RequestBody UserDto userDto)
    {
        m_paymentUserService.updateUser(userDto);
    }

    @PutMapping("/password")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Boolean> updatePassword(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(m_paymentUserService.updatePassword(userDto));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto)
    {
        log.info("Register user {}", userDto.getUsername());

        return ResponseEntity.ok(m_paymentUserService.register(userDto));
    }

    //...
}

