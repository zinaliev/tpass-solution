package com.genesys.tpass.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationResultDto {

    private Boolean passed;

    public Boolean getPassed() {
        return passed;
    }

    public VerificationResultDto setPassed(Boolean passed) {
        this.passed = passed;
        return this;
    }
}
