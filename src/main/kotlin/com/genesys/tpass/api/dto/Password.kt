package com.genesys.tpass.api.dto

import com.fasterxml.jackson.annotation.JsonInclude

/**
 *
 * @author rzinalie
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Password (
        val password: String
) {
}