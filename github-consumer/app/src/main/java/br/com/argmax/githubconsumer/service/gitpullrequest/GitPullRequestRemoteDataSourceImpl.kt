package br.com.argmax.githubconsumer.service.gitpullrequest

import androidx.annotation.NonNull

class GitPullRequestRemoteDataSourceImpl(
    private val mGitPullRequestApiDataSource: GitPullRequestApiDataSource
) : GitPullRequestRemoteDataSource {

    companion object {

        @Volatile
        private var INSTANCE: GitPullRequestRemoteDataSourceImpl? = null

        fun getInstance(@NonNull gitPullRequestApiDataSource: GitPullRequestApiDataSource): GitPullRequestRemoteDataSourceImpl =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: GitPullRequestRemoteDataSourceImpl(gitPullRequestApiDataSource).also {
                    INSTANCE = it
                }
            }

    }

    override suspend fun getGitPullRequestDtoList(owner: String, repository: String, page: Int?) =
        mGitPullRequestApiDataSource.getGitPullRequestDtoList(
            owner = owner,
            repository = repository,
            page = page
        )

}