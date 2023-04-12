package com.example.users.model

data class User(
    val id: Long,
    val login: String,
    val avatar_url: String,
    val html_url: String,
    val type: String,
    val site_admin: Boolean
)
