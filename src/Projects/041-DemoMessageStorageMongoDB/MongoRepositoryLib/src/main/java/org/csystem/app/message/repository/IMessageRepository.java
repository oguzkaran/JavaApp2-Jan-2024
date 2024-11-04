package org.csystem.app.message.repository;

import org.csystem.app.message.repository.document.Message;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageRepository extends MongoRepository<Message, String> {
    List<Message> findByFromAndTo(String from, String to);

    @Query("{}")
    List<Message> findByContentAsTextContains(String text);
}
