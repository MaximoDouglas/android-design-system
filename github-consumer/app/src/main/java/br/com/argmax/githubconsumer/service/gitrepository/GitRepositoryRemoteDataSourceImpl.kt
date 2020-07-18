package br.com.argmax.githubconsumer.service.gitrepository

import android.annotation.SuppressLint
import androidx.annotation.NonNull
import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryApiResponse
import br.com.argmax.githubconsumer.service.RemoteDataSourceCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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

    @SuppressLint("CheckResult")
    override fun getGitRepositoryApiResponse(
        page: Int,
        callback: RemoteDataSourceCallback<GitRepositoryApiResponse>
    ) {
        mGitRepositoryApiDataSource.getGitRepositoryApiResponse(
            page = page
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.isLoading(true) }
            .doAfterTerminate { callback.isLoading(false) }
            .subscribe(
                { response ->
                    callback.onSuccess(response)
                },
                { throwable ->
                    callback.onError(throwable.localizedMessage)
                }
            )
    }

}