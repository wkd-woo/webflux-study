package com.example.webflux.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document(collection = "accounts")
@AllArgsConstructor
public class Account {

    @Id
    private String id;
    private String owner;
    private Double value;

}
