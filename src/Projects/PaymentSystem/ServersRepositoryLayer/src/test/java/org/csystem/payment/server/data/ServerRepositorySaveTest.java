package org.csystem.payment.server.data;

import org.csystem.payment.server.data.entity.ServerInfo;
import org.csystem.payment.server.data.repository.IServerInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest_save.properties")
public class ServerRepositorySaveTest {
    @Autowired
    private IServerInfoRepository m_serverRepository;

    @Test
    public void test()
    {
        m_serverRepository.save(new ServerInfo("XXXXX", "YYYYY", "ZZZZZ", LocalDate.of(1993, Month.SEPTEMBER, 30).atTime(0, 0)));

        assertTrue(m_serverRepository.findById("XXXXX").isPresent());
    }
}
