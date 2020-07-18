package br.com.argmax.githubconsumer.service

interface RemoteDataSourceCallback<R> {

    fun onSuccess(response: R)
    fun onError(errorMessage: String)
    fun isLoading(isLoading: Boolean)

}