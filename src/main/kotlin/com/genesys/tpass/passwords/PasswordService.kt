package com.genesys.tpass.passwords

import com.genesys.tpass.passwords.models.UserInfo
import com.google.common.collect.Maps
import java.util.*
import java.util.concurrent.ConcurrentMap

class PasswordService (
    private val users : ConcurrentMap<String, UserInfo> ) : IPasswordService {

    constructor() : this(Maps.newConcurrentMap())

    override fun createPassword(userName: String, timeout: Int): String {

        val newPass = UUID.randomUUID()?.toString() ?: throw RuntimeException("failed to generate pass for $userName")
        val newInfo = UserInfo(userName, newPass, timeout)

        users.put(userName, newInfo)

        return newPass
    }

    override fun verifyPassword(userName: String, password: String): Boolean {
        val info = users.get(userName) ?: return false

        return password == info.password
    }
}