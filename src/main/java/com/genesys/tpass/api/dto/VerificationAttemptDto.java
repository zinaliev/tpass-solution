package com.genesys.tpass.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationAttemptDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private LocalDateTime time;

    private String username;

    private Boolean passed;

    public LocalDateTime getTime() {
        return time;
    }

    public VerificationAttemptDto setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public VerificationAttemptDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public Boolean getPassed() {
        return passed;
    }

    public VerificationAttemptDto setPassed(Boolean passed) {
        this.passed = passed;
        return this;
    }
}
