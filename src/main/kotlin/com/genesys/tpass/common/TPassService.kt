package com.genesys.tpass.common

import com.genesys.tpass.common.models.ApiResponse

class TPassService {

    companion object {
        val instance = TPassService()
    }

    fun createPassword(userName: String, timeout: Int) : ApiResponse<Any> {
        throw NotImplementedError("createPassword")
    }

    fun verifyPassword(userName: String, password: String): ApiResponse<Any> {
        throw NotImplementedError("verifyPassword")
    }

    fun getOperationsCount() : ApiResponse<Any> {
        throw NotImplementedError("getOperationsCount")
    }

    fun getVerificationsLog(itemsCount: Int?) : ApiResponse<Any> {
        throw NotImplementedError("getVerificationsLog")
    }
}