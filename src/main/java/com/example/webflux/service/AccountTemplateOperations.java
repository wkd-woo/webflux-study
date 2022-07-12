package com.example.webflux.service;

import com.example.webflux.domain.Account;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountTemplateOperations {

    @Autowired
    ReactiveMongoTemplate template;

    public Mono<Account> findById(ObjectId id) {
        return template.findById(id, Account.class);
    }

    public Flux<Account> findAll() {
        return template.findAll(Account.class);
    }

    public Mono<Account> save(Mono<Account> account) {
        return template.save(account);
    }
}
