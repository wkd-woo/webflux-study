package com.example.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello World! I'm Mono");
    }

    @GetMapping("/hello-flux")
    public Flux<String> helloFlux() {
        return Flux.just("Hello", " ", "World!" , " ", "I'm Flux!");
    }

}
