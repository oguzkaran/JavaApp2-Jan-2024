package org.csystem.payment.server.data;

import org.csystem.payment.server.data.repository.IServerInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest_count.properties")
@Sql(scripts = {"/ddl-count.sql", "/dml-count.sql"})
public class ServerRepositoryCountTest {
    @Autowired
    private IServerInfoRepository m_serverRepository;

    @Test
    public void test()
    {
        var expectedCount = 1000L;

        assertEquals(expectedCount, m_serverRepository.count());
    }
}
