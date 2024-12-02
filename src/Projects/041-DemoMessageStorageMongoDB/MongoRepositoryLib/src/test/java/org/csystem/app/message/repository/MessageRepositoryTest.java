package org.csystem.app.message.repository;

import org.csystem.app.message.repository.document.Message;
import static org.junit.jupiter.api.Assertions.*;
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

    private void setupData()
    {
        m_messageRepository.insert(Message.builder().from("ali").to("veli").content("Hello Veli").build());
        m_messageRepository.insert(Message.builder().from("ali").to("veli").content("Fine thanks").build());
        m_messageRepository.insert(Message.builder().from("ali").to("veli").content("Where are you?").build());
        m_messageRepository.insert(Message.builder().from("veli").to("ali").content("Hi. How are you?").build());
        m_messageRepository.insert(Message.builder().from("veli").to("ali").content("thanks?").build());
    }

    @BeforeEach
    public void setup()
    {
        m_messageRepository.deleteAll();
        setupData();
    }

    @Test
    public void givenValues_whenFromAndTo_thenFindMessageSize()
    {
        var expectedSize = 3;
        var from = "ali";
        var to = "veli";
        var messages = m_messageRepository.findByFromAndTo(from, to);

        assertEquals(expectedSize, messages.size());
    }

    @Test
    public void givenValues_whenTextContains_thenFindMessageSize()
    {
        var expectedSize = 2;
        var text = "thanks";
        var messages = m_messageRepository.findByContentContains(text);

        assertEquals(expectedSize, messages.size());
    }
}
