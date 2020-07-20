package br.com.argmax.githubconsumer.faker

import br.com.argmax.githubconsumer.domain.entities.user.GitUserDto

object GitUserDtoFaker {

    private val mGitUserDtoFirst = GitUserDto(
        login = "CyC2018",
        avatar_url = "https://avatars3.githubusercontent.com/u/36260787?v=4"
    )

    private val mGitUserDtoSecond = GitUserDto(
        login = "alibaba",
        avatar_url = "https://avatars1.githubusercontent.com/u/1961952?v=4"
    )

    fun getFirst(): GitUserDto {
        return mGitUserDtoFirst
    }

    fun getSecond(): GitUserDto {
        return mGitUserDtoSecond
    }

}