package org.csystem.app.postalcodesearch.controller;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.postalcodesearch.dto.payment.PostalCodes;
import org.csystem.app.postalcodesearch.service.PostalCodeSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postalcodesearch")
@Slf4j
@AllArgsConstructor
@Accessors(prefix = "m_")
public class PostalCodeSearchController {
    private final PostalCodeSearchService m_postalCodeSearchService;

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PostalCodes> postalCodes(String postalCode, int maxRows)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PostalCodes> postalCodes(String postalCodes)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //...
}

