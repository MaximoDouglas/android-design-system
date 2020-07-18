package br.com.argmax.githubconsumer.service.gitrepository

import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryApiResponse
import br.com.argmax.githubconsumer.service.RemoteDataSourceCallback

interface GitRepositoryRemoteDataSource {

    fun getGitRepositoryApiResponse(
        page: Int,
        callback: RemoteDataSourceCallback<GitRepositoryApiResponse>
    )

}