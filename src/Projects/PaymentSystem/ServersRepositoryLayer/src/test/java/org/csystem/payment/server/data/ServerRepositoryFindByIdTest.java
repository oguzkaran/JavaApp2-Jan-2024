package org.csystem.payment.server.data;

import org.csystem.payment.server.data.repository.IServerInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootApplication
@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest.properties")
public class ServerRepositoryFindByIdTest {
    @Autowired
    private IServerInfoRepository m_serverRepository;

    @Test
    public void givenValue_whenId_thenFound()
    {
        var expectedId = "ec136e6a-f690-4841-85b6-30d0b7c635cd";
        var serverOpt = m_serverRepository.findById(expectedId);

        assertTrue(serverOpt.isPresent());
    }

    @Test
    public void givenValue_whenId_thenNotFound()
    {
        var expectedId = "ec136e6a-f670-4841-85b6-30d0b7c635cd";
        var serverOpt = m_serverRepository.findById(expectedId);

        assertTrue(serverOpt.isEmpty());
    }
}
