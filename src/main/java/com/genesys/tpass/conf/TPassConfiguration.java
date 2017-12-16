package com.genesys.tpass.conf;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class TPassConfiguration extends Configuration {

    @JsonProperty("history_size")
    private Integer historySize;

    public Integer getHistorySize() {
        return historySize;
    }

    public void setHistorySize(Integer historySize) {
        this.historySize = historySize;
    }
}
