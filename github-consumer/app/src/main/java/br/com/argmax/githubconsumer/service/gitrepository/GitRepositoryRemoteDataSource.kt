package br.com.argmax.githubconsumer.service.gitrepository

import androidx.lifecycle.LiveData
import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryDto

interface GitRepositoryRemoteDataSource {

    /*fun getGitRepositoryApiResponse(
        page: Int,
        callback: RemoteDataSourceCallback<GitRepositoryApiResponse>
    )*/

    suspend fun getGitRepositoryApiResponse(
        page: Int
    ): List<GitRepositoryDto>

}