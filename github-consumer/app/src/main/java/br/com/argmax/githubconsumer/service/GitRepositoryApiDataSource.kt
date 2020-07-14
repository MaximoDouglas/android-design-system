package br.com.argmax.githubconsumer.service

import br.com.argmax.githubconsumer.domain.entities.GitRepositoryApiResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GitRepositoryApiDataSource {

    @GET("search/repositories")
    fun getGitRepositories(
        @Query("q") q: String? = "language:Java",
        @Query("sort") sort: String? = "stars",
        @Query("page") page: Int
    ): Observable<GitRepositoryApiResponse>

}