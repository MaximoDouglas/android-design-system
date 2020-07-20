package br.com.argmax.githubconsumer.di

import br.com.argmax.githubconsumer.service.ApiDataSource
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryApiDataSource
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSource
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class RemoteDataSourceModule {

    @Singleton
    @Binds
    abstract fun provideGitRepositoryRemoteDataSource(
        remoteDataSource: GitRepositoryRemoteDataSourceImpl
    ): GitRepositoryRemoteDataSource

}

@Module
object ApiDataSourceModule {

    @Provides
    @Singleton
    fun provideGitRepositoryApiDataSource(): GitRepositoryApiDataSource {
        return ApiDataSource.createService(GitRepositoryApiDataSource::class.java)
    }

}