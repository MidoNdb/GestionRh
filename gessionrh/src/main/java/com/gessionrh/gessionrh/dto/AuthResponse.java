package com.gessionrh.gessionrh.dto;

import com.gessionrh.gessionrh.entity.AppUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private final String token;
    private final AppUser user;
}
