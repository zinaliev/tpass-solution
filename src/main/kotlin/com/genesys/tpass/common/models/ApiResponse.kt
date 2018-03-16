package com.genesys.tpass.common.models

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * @author rzinalie
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiResponse<T>(
        val message: String,
        val code: StatusCode,
        val data: T?) {

    companion object {

        fun notImplemented(methodName: String): ApiResponse<Any> {
            return ApiResponse("method $methodName is not implemented", StatusCode.NOT_IMPLEMENTED, null)
        }
    }
}