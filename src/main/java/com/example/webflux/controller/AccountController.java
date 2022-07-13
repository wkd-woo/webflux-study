package com.example.webflux.controller;

import com.example.webflux.domain.Account;
import com.example.webflux.dto.AccountDto;
import com.example.webflux.repostory.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
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
    public ResponseEntity addAccount(@RequestBody AccountDto accountDto) {
        accountRepository.save(accountDto.toEntity());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Mono<Account> getAccountById(@PathVariable String id) {
        return accountRepository.findById(new ObjectId(id));
    }

    @GetMapping
    public Flux<Account> findAllAccount() {
        return accountRepository.findAll();
    }

    @GetMapping("/owner")
    public Flux<Account> findAllByOwner(@RequestBody AccountDto accountDto) {
        return accountRepository.findAllByOwner(accountDto.getOwner());
    }

    @GetMapping("/value")
    public Flux<Account> findAllByValue(@RequestBody AccountDto accountDto) {
        return accountRepository.findAllByValue(accountDto.getValue());
    }
}
