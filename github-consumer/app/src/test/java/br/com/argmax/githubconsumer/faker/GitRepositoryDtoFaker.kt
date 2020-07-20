package br.com.argmax.githubconsumer.faker

import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryDto

object GitRepositoryDtoFaker {

    private val gitRepositoryFirst = GitRepositoryDto(
        name = "CS-Notes",
        owner = GitUserDtoFaker.getFirst(),
        description = ":books: 技术面试必备基础知识、Leetcode、计算机操作系统、计算机网络、系统设计、Java、Python、C++",
        forks_count = 34734,
        stargazers_count = 106549
    )

    private val gitRepositorySecond = GitRepositoryDto(
        name = "fastjson",
        owner = GitUserDtoFaker.getSecond(),
        description = "A fast JSON parser/generator for Java.  ",
        forks_count = 5862,
        stargazers_count = 22022
    )

    fun getFirst(): GitRepositoryDto {
        return gitRepositoryFirst
    }

    fun getList(): List<GitRepositoryDto> {
        return listOf(gitRepositoryFirst, gitRepositorySecond)
    }

}