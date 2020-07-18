package br.com.argmax.githubconsumer.domain

interface UseCaseCallback<R> {

    fun onSuccess(response: R)
    fun onError(errorMessage: String)
    fun isLoading(isLoading: Boolean)

}