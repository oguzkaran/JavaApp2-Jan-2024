package org.csystem.app.postalcodesearch.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@Accessors(prefix = "m_")
@RequiredArgsConstructor
public class PostalCodeSearchService {
    private final RestTemplate m_restTemplate;

    @Value("${geonames.postalcodesearch.url}")
    private String m_url;


}
