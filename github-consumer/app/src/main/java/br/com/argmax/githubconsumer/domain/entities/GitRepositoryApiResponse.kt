package br.com.argmax.githubconsumer.domain.entities

import java.io.Serializable

data class GitRepositoryApiResponse(
    val items: List<GitRepositoryDto>
) : Serializable