package com.genesys.tpass.statistics.models

import com.fasterxml.jackson.annotation.JsonInclude

/**
 *
 * @author rzinalie
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class OperationsCount(
    val passwordsCreated : Int,
    val verificationsPassed: Int,
    val verificationsFailed: Int
) {
}