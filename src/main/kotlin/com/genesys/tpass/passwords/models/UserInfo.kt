package com.genesys.tpass.passwords.models

data class UserInfo (
        val name: String,
        val password: String,
        val timeout: Int
){
}