package br.com.argmax.githubconsumer.ui.modules.gitrepositories

import android.annotation.SuppressLint
import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryApiResponse
import br.com.argmax.githubconsumer.service.ApiDataSource.Companion.createService
import br.com.argmax.githubconsumer.service.GitRepositoryApiDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GitRepositoryRepository {

    private val mService = createService(GitRepositoryApiDataSource::class.java)

    @SuppressLint("CheckResult")
    fun getGitRepositoryApiResponse(
        page: Int,
        callback: (gitRepositoryApiResponse: GitRepositoryApiResponse) -> Unit
    ) {
        mService.getGitRepositories(
            page = page
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isLoading(true) }
            .doAfterTerminate { isLoading(false) }
            .subscribe(
                { response ->
                    callback.invoke(response)
                },
                { throwable ->
                    println(throwable.localizedMessage)
                }
            )
    }

    private fun isLoading(isLoading: Boolean) {
        println(isLoading)
    }

}