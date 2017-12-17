package com.genesys.tpass.api.dto

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * @author rzinalie
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiResponse<T>(
        var message: String,
        var code: StatusCode,
        var data: T?) {

    companion object {

        fun notImplemented(methodName: String): ApiResponse<Any> {
            return ApiResponse("method $methodName is not implemented", StatusCode.NOT_IMPLEMENTED, null)
        }
    }
}