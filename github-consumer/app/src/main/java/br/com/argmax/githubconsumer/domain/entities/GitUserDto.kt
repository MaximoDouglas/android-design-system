package br.com.argmax.githubconsumer.domain.entities

import java.io.Serializable

data class GitUserDto(
    val avatar_url: String,
    val login: String
) : Serializable