package org.csystem.app.postalcodesearch.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.postalcodesearch.dto.payment.PostalCodes;
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

    @Value("${geonames.postalcodesearch.maxRows}")
    private int m_maxRows;

    public PostalCodes findPostalCodes(String postalCode, int maxRows)
    {
        return m_restTemplate.getForObject(m_url.formatted(postalCode, maxRows), PostalCodes.class, maxRows);
    }

    public PostalCodes findPostalCodes(String postalCode)
    {
        return findPostalCodes(postalCode, m_maxRows);
    }
}
