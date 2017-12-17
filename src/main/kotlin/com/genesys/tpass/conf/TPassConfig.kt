package com.genesys.tpass.conf

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

/**
 *
 * @author rzinalie
 */
class TPassConfig : Configuration() {

    @JsonProperty("history_size")
    var historySize: Int = 0
}