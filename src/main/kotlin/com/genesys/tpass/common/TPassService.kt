package com.genesys.tpass.common

import com.genesys.tpass.common.models.ApiResponse
import com.genesys.tpass.passwords.IPasswordService
import com.genesys.tpass.passwords.PasswordService
import com.genesys.tpass.passwords.models.Password
import com.genesys.tpass.passwords.models.VerificationResult

class TPassService (private val passwords: IPasswordService) {

    companion object {
        val instance = TPassService()
    }

    constructor() : this(PasswordService())

    fun createPassword(userName: String, timeout: Int) : ApiResponse<Any> {
        val result = passwords.createPassword(userName, timeout)

        return ApiResponse.ok(Password(result))
    }

    fun verifyPassword(userName: String, password: String): ApiResponse<Any> {
        val result = passwords.verifyPassword(userName, password)

        return ApiResponse.ok(VerificationResult(result))
    }

    fun getOperationsCount() : ApiResponse<Any> {
        throw NotImplementedError("getOperationsCount")
    }

    fun getVerificationsLog(itemsCount: Int?) : ApiResponse<Any> {
        throw NotImplementedError("getVerificationsLog")
    }
}