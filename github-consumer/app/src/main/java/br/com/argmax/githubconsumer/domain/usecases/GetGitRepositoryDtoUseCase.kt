package br.com.argmax.githubconsumer.domain.usecases

import br.com.argmax.githubconsumer.domain.UseCaseCallback
import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryApiResponse
import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryDto
import br.com.argmax.githubconsumer.service.RemoteDataSourceCallback
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSource

class GetGitRepositoryDtoUseCase(private val gitRepositoryRemoteDataSource: GitRepositoryRemoteDataSource) {

    fun getGitRepositoryDtoList(
        page: Int,
        callback: UseCaseCallback<List<GitRepositoryDto>>
    ) {
        gitRepositoryRemoteDataSource.getGitRepositoryApiResponse(
            page,
            object : RemoteDataSourceCallback<GitRepositoryApiResponse> {
                override fun onSuccess(response: GitRepositoryApiResponse) {
                    callback.onSuccess(response.items)
                }

                override fun onError(errorMessage: String) {
                    callback.onError(errorMessage)
                }

                override fun isLoading(isLoading: Boolean) {
                    callback.isLoading(isLoading)
                }
            })
    }


}