package com.example.webflux.repostory;

import com.example.webflux.domain.Account;
import reactor.core.publisher.Flux;

public interface CustomAccountRepository {

    Flux<Account> findAllByOwner(String owner);
}
