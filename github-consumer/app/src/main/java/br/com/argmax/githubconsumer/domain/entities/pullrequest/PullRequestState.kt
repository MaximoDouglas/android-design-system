package br.com.argmax.githubconsumer.domain.entities.pullrequest

enum class PullRequestState(val value: String) {
    OPEN("open"),
    CLOSED("closed")
}