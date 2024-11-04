package org.csystem.app.message.repository.document;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document(collection = "messages")
@EqualsAndHashCode
@ToString
@Builder
public class Message {
    @MongoId
    public String id;
    public String from;
    public String to;
    public Object content;
    public LocalDateTime dateTime = LocalDateTime.now();
    //...
}
