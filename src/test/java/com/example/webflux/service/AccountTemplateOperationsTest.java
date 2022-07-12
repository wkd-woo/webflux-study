package com.example.webflux.service;

import com.example.webflux.domain.Account;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountTemplateOperationsTest {

    @Autowired
    AccountTemplateOperations templateOperations;

    /**
     * https://sabarada.tistory.com/133
     * Webflux Reactor 유닛 테스트하기
     */

    @Test
    @DisplayName("Id로 조회 테스트")
    void findById() throws Exception {
        Mono<Account> accountMono = templateOperations.findById(new ObjectId("62cd1a67d2a9e1108e1316e6"));

        StepVerifier
                .create(accountMono)
                .assertNext(account -> {
                    assertEquals("Jay", account.getOwner());
                    assertEquals(12.3, account.getValue());
                })
                .expectComplete()
                .verify();
    }

    @Test
    @DisplayName("전체조회")
    void findAll() throws Exception {
        Flux<Account> accountFlux = templateOperations.findAll();

        StepVerifier.create(accountFlux)
                .assertNext(account -> {
                    assertEquals(account.getValue(), 12.3);
                })
                .expectComplete()
                .verify();
    }

}