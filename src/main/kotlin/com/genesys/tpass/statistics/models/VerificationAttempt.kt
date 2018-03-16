package com.genesys.tpass.statistics.models

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

/**
 * @author rzinalie
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class VerificationAttempt (

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
        val time: LocalDateTime,
        val username: String,
        val passed: Boolean
) {
}