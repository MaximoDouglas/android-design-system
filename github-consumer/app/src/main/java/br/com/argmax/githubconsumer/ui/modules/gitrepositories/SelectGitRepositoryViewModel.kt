package br.com.argmax.githubconsumer.ui.modules.gitrepositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryApiResponse

class SelectGitRepositoryViewModel(
    private val gitRepositoryRepository: GitRepositoryRepository
) : ViewModel() {

    val gitRepositoryApiResponseLiveData = MutableLiveData<GitRepositoryApiResponse>()

    fun getGitRepositoryApiResponse(page: Int) {
        gitRepositoryRepository.getGitRepositoryApiResponse(page) { gitRepositoryApiResponse ->
            gitRepositoryApiResponseLiveData.value = gitRepositoryApiResponse
        }
    }

    class SelectGitRepositoryViewModelFactory(
        private val gitRepositoryRepository: GitRepositoryRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SelectGitRepositoryViewModel(gitRepositoryRepository) as T
        }
    }

}
