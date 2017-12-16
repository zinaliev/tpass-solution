package com.genesys.tpass.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationsCountDto {

    private Integer passwordsCreated;

    private Integer verificationsPassed;

    private Integer verificationsFailed;

    public Integer getPasswordsCreated() {
        return passwordsCreated;
    }

    public OperationsCountDto setPasswordsCreated(Integer passwordsCreated) {
        this.passwordsCreated = passwordsCreated;
        return this;
    }

    public Integer getVerificationsPassed() {
        return verificationsPassed;
    }

    public OperationsCountDto setVerificationsPassed(Integer verificationsPassed) {
        this.verificationsPassed = verificationsPassed;
        return this;
    }

    public Integer getVerificationsFailed() {
        return verificationsFailed;
    }

    public OperationsCountDto setVerificationsFailed(Integer verificationsFailed) {
        this.verificationsFailed = verificationsFailed;
        return this;
    }
}
