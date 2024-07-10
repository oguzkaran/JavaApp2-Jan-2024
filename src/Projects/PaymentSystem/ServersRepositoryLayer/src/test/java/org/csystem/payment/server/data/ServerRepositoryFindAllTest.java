package org.csystem.payment.server.data;

import org.csystem.payment.server.data.repository.IServerInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest.properties")
public class ServerRepositoryFindAllTest {
    @Autowired
    private IServerInfoRepository m_serverRepository;

    @Test
    public void test()
    {
        var servers = m_serverRepository.findAll();
        var expectedCount = 1000L;

        assertEquals(expectedCount, StreamSupport.stream(servers.spliterator(), false).count());
    }
}
