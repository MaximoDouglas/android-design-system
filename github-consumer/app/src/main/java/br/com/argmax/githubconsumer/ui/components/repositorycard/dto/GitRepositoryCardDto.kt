package br.com.argmax.githubconsumer.ui.components.repositorycard.dto

import br.com.argmax.githubconsumer.utils.compactStringWithDots

class GitRepositoryCardDto(
    val gitRepositoryName: String,
    private val gitRepositoryDescription: String,
    val forkQuantity: String,
    val starsQuantity: String,
    val userImageUrl: String,
    val userName: String,
    val userFullName: String? = "Default name"
) {
    fun getGitRepositoryDescription(): String {
        return compactStringWithDots(gitRepositoryDescription, 60)
    }
}