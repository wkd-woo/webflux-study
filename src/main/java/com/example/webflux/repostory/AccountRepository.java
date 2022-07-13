package com.example.webflux.repostory;

import com.example.webflux.domain.Account;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, ObjectId>, CustomAccountRepository {

    Flux<Account> findAllByValue(Double value);

    Mono<Account> findFirstByOwner(Mono<String> owner);

}
