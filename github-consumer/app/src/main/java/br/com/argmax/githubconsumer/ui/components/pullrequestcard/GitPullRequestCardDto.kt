package br.com.argmax.githubconsumer.ui.components.pullrequestcard

import br.com.argmax.githubconsumer.utils.compactStringWithDots

class GitPullRequestCardDto(
    val gitPullRequestTitle: String,
    private val gitPullRequestBody: String,
    val userImageUrl: String,
    val userName: String
) {
    fun getGitPullRequestBody(): String {
        return compactStringWithDots(gitPullRequestBody, 60)
    }
}