package br.com.argmax.githubconsumer.service.gitrepository

import androidx.annotation.NonNull

class GitRepositoryRemoteDataSourceImpl(
    private val mGitRepositoryApiDataSource: GitRepositoryApiDataSource
) : GitRepositoryRemoteDataSource {

    companion object {

        @Volatile
        private var INSTANCE: GitRepositoryRemoteDataSourceImpl? = null

        fun getInstance(@NonNull gitRepositoryApiDataSource: GitRepositoryApiDataSource): GitRepositoryRemoteDataSourceImpl =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: GitRepositoryRemoteDataSourceImpl(gitRepositoryApiDataSource).also {
                    INSTANCE = it
                }
            }

    }

    override suspend fun getGitRepositoryApiResponse(page: Int) =
        mGitRepositoryApiDataSource.getGitRepositoryApiResponse(page = page).items


}