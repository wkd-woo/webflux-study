package com.example.webflux.controller;

import com.example.webflux.domain.Account;
import com.example.webflux.domain.AccountDto;
import com.example.webflux.repostory.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountRepository accountRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addAccount(@RequestBody AccountDto account) {
        accountRepository.save(account.toEntity());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Mono<Account> getAccountById(@PathVariable String id) {
        return accountRepository.findById(id);
    }

    @GetMapping
    public Flux<Account> findAllAccount() {
        return accountRepository.findAll();
    }

    @GetMapping("/{value}")
    public Flux<Account> findAllByValue(@RequestBody Double value) {
        return accountRepository.findAllByValue(value);
    }
}
