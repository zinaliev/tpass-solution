package com.genesys.tpass.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PasswordDto {

    private String password;

    public String getPassword() {
        return password;
    }

    public PasswordDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
