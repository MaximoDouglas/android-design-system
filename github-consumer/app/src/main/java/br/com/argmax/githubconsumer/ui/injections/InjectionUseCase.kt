package br.com.argmax.githubconsumer.ui.injections

import br.com.argmax.githubconsumer.domain.usecases.GetGitRepositoryDtoUseCase
import br.com.argmax.githubconsumer.ui.injections.InjectionRemoteDataSource.provideGitRepositoryRemoteDataSource

object InjectionUseCase {

    fun provideGetGitRepositoryDtoUseCase(): GetGitRepositoryDtoUseCase {
        val gitRepositoryRemoteDataSource = provideGitRepositoryRemoteDataSource()
        return GetGitRepositoryDtoUseCase(gitRepositoryRemoteDataSource)
    }

}