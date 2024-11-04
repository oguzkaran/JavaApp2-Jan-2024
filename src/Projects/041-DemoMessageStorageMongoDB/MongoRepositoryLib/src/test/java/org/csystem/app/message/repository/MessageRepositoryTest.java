package org.csystem.app.message.repository;


import org.csystem.app.message.repository.document.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootApplication
@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest.properties")
public class MessageRepositoryTest {
    @Autowired
    private IMessageRepository m_messageRepository;

    @BeforeEach
    public void setup()
    {
        m_messageRepository.deleteAll();
        m_messageRepository.insert(Message.builder().from("ali").to("veli").content("Hello Veli").build());
        m_messageRepository.insert(Message.builder().from("veli").to("ali").content("Hi. How are you?").build());
    }

    @Test
    public void test()
    {
        //...
    }
}
