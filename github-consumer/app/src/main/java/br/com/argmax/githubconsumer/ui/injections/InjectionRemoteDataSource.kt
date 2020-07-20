package br.com.argmax.githubconsumer.ui.injections

import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSource
import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSourceImpl
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSource
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSourceImpl
import br.com.argmax.githubconsumer.ui.injections.InjectionApiDataSource.provideGitPullRequestApiDataSource
import br.com.argmax.githubconsumer.ui.injections.InjectionApiDataSource.provideGitRepositoryApiDataSource

object InjectionRemoteDataSource {

    fun provideGitPullRequestRemoteDataSource(): GitPullRequestRemoteDataSource {
        return GitPullRequestRemoteDataSourceImpl.getInstance(provideGitPullRequestApiDataSource())
    }

}