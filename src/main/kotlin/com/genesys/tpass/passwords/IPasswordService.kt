package com.genesys.tpass.passwords

interface IPasswordService {
    fun createPassword(userName: String, timeout: Int) : String
    fun verifyPassword(userName: String, password: String) : Boolean
}