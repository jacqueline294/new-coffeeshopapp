package com.example.coffeshopapp

data class Credentials(
    var username: String = "",
    var password: String = "",
    var remember: Boolean = false
) {
    fun isNotEmpty(): Boolean = username.isNotEmpty() && password.isNotEmpty()

    fun validate(): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }
}

