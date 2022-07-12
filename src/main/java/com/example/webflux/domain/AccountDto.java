package com.example.webflux.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccountDto {

    private String owner;
    private Double value;

    public Account toEntity() {
        return Account.builder()
                .owner(owner)
                .value(value)
                .build();
    }
}
