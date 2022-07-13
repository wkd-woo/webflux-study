package com.example.webflux.repostory;


import com.example.webflux.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class CustomAccountRepositoryImpl implements CustomAccountRepository {

    private final ReactiveMongoTemplate mongoTemplate;

    @Override
    public Flux<Account> findAllByOwner(String owner) {
        Query query = new Query();
        query.addCriteria(Criteria.where("owner").is(owner));

        return mongoTemplate.find(query, Account.class);
    }
}
