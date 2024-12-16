package org.csystem.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
@Slf4j
public class IpInformationController {
    private final HttpServletRequest m_httpServletRequest;

    public IpInformationController(HttpServletRequest httpServletRequest)
    {
        m_httpServletRequest = httpServletRequest;
    }

    @GetMapping("/ip")
    public String ipInfo()
    {
        log.info("Ip:{}", m_httpServletRequest.getRemoteAddr());

        return m_httpServletRequest.getRemoteAddr();
    }
}
