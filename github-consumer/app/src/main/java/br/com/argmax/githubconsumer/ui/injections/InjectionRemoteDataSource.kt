package br.com.argmax.githubconsumer.ui.injections

import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSource
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSourceImpl
import br.com.argmax.githubconsumer.ui.injections.InjectionApiDataSource.provideGitRepositoryApiDataSource

object InjectionRemoteDataSource {

    fun provideGitRepositoryRemoteDataSource(): GitRepositoryRemoteDataSource {
        return GitRepositoryRemoteDataSourceImpl.getInstance(provideGitRepositoryApiDataSource())
    }

}