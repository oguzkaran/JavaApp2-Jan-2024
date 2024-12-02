package org.csystem.app.message.repository;

import org.csystem.app.message.repository.document.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageRepository extends MongoRepository<Message, String> {
    @Query("{'from': ?0, 'to':  ?1}")  //That is not needed. Just used for demonstration
    List<Message> findByFromAndTo(String from, String to);

    @Query("{ '$text': {'$search':  \"?0\"} }") //That is not needed. Just used for demonstration
    List<Message> findByContentContains(String text);
}
