package br.com.argmax.githubconsumer.ui.injections

import br.com.argmax.githubconsumer.service.ApiDataSource.Companion.createService
import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestApiDataSource
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryApiDataSource

object InjectionApiDataSource {

    fun provideGitRepositoryApiDataSource(): GitRepositoryApiDataSource {
        return createService(GitRepositoryApiDataSource::class.java)
    }

    fun provideGitPullRequestApiDataSource(): GitPullRequestApiDataSource {
        return createService(GitPullRequestApiDataSource::class.java)
    }

}