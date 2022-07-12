package com.example.webflux.repostory;

import com.example.webflux.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository repository;


    @Test
    void givenValue_whenFindAllByValue_thenFindAccount() throws Exception {
        repository.save(new Account(null, "Jay", 12.3)).block();
        Flux<Account> accountFlux = repository.findAllByValue(12.3);

        StepVerifier.create(accountFlux)
                .assertNext(account -> {
                    assertEquals("Jay", account.getOwner());
                    assertEquals(Double.valueOf(12.3), account.getValue());
                    assertNotNull(account.getId());
                })
                .expectComplete()
                .verify();
    }

    @Test
    public void givenOwner_whenFindFirstByOwner_thenFindAccount() {
        repository.save(new Account(null, "Bill", 12.3)).block();
        Mono<Account> accountMono = repository
                .findFirstByOwner(Mono.just("Bill"));

        StepVerifier
                .create(accountMono)
                .assertNext(account -> {
                    assertEquals("Bill", account.getOwner());
                    assertEquals(Double.valueOf(12.3) , account.getValue());
                    assertNotNull(account.getId());
                })
                .expectComplete()
                .verify();
    }

    @Test
    public void givenAccount_whenSave_thenSaveAccount() {
        Mono<Account> accountMono = repository.save(new Account(null, "Jordan", 12.3));

        StepVerifier
                .create(accountMono)
                .assertNext(account -> assertNotNull(account.getId()))
                .expectComplete()
                .verify();
    }

}