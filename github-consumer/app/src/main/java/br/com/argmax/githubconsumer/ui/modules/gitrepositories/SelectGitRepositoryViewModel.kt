package br.com.argmax.githubconsumer.ui.modules.gitrepositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.argmax.githubconsumer.domain.UseCaseCallback
import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryDto
import br.com.argmax.githubconsumer.domain.usecases.GetGitRepositoryDtoUseCase

class SelectGitRepositoryViewModel(
    private val getGitRepositoryDtoUseCase: GetGitRepositoryDtoUseCase
) : ViewModel() {

    val gitRepositoryApiResponseLiveData = MutableLiveData<List<GitRepositoryDto>>()

    fun getGitRepositoryApiResponse(page: Int) {
        getGitRepositoryDtoUseCase.getGitRepositoryDtoList(
            page,
            object :
                UseCaseCallback<List<GitRepositoryDto>> {
                override fun onSuccess(response: List<GitRepositoryDto>) {
                    gitRepositoryApiResponseLiveData.value = response
                }

                override fun onError(errorMessage: String) {
                    println(errorMessage)
                }

                override fun isLoading(isLoading: Boolean) {
                    println(isLoading)
                }
            })
    }

    class SelectGitRepositoryViewModelFactory(
        private val gitRepositoryRepositoryDto: GetGitRepositoryDtoUseCase
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SelectGitRepositoryViewModel(gitRepositoryRepositoryDto) as T
        }
    }

}
