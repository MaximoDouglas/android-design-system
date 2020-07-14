package br.com.argmax.githubconsumer.domain.entities

import java.io.Serializable

data class GitRepositoryDto(
    val name: String,
    val description: String,
    val forks_count: Int,
    val stargazers_count: Int,
    val owner: GitUserDto
) : Serializable