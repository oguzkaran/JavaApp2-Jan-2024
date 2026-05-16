package org.csystem.app.postalcodesearch.controller;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.postalcodesearch.dto.user.UserDto;
import org.csystem.app.postalcodesearch.service.PostalCodeSearchUserService;
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
    private final PostalCodeSearchUserService m_postalCodeSearchUserService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto)
    {
        log.info("Add user {}", userDto.getUsername());

        return ResponseEntity.ok(m_postalCodeSearchUserService.addUser(userDto));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> getUser(@RequestParam(name = "name") String username)
    {
        return m_postalCodeSearchUserService.findByUsername(username).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void updateUser(@RequestBody UserDto userDto)
    {
        m_postalCodeSearchUserService.updateUser(userDto);
    }

    @PutMapping("/password")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Boolean> updatePassword(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(m_postalCodeSearchUserService.updatePassword(userDto));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto)
    {
        log.info("Register user {}", userDto.getUsername());

        return ResponseEntity.ok(m_postalCodeSearchUserService.register(userDto));
    }

    //...
}

