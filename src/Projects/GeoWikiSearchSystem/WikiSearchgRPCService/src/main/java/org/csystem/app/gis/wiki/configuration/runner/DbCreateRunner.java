package org.csystem.app.gis.wiki.configuration.runner;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.DriverManager;

@Component
@Profile("!dev")
@Slf4j
public class DbCreateRunner {
    private static final String CREATE_DATABASE_SQL = "SELECT 'CREATE DATABASE %s' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = '%s');";
    @Value("${spring.datasource.url}")
    private String m_url;

    @Value("${spring.datasource.username}")
    private String m_username;

    @Value("${spring.datasource.password}")
    private String m_password;

    @Value("${app.dbname}")
    private String m_dbName;

    @PostConstruct
    public void run()
    {
        log.info("CREATE DATABASE:{}", m_dbName);
        try (var con = DriverManager.getConnection(m_url, m_username, m_password);
             var statement = con.prepareStatement(CREATE_DATABASE_SQL.formatted(m_dbName, m_dbName))) {

            statement.executeUpdate();
        }
        catch (Throwable ex) {
            throw new RuntimeException("", ex);
        }
    }
}
