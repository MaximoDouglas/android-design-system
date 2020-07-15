package br.com.argmax.githubconsumer.ui.modules.gitrepositories

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.SelectGitRepositoryFragmentBinding
import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryApiResponse
import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryDto
import br.com.argmax.githubconsumer.service.ApiDataSource.Companion.createService
import br.com.argmax.githubconsumer.service.GitRepositoryApiDataSource
import br.com.argmax.githubconsumer.ui.components.repositorycard.dto.GitRepositoryCardDto
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.SelectGitRepositoryFragmentDirections.actionSelectRepositoryFragmentToSelectGitPullRequestFragment
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.adapters.SelectGitRepositoryAdapter
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.listeners.OnGitRepositoryClickListener
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class SelectGitRepositoryFragment : Fragment(), OnGitRepositoryClickListener {

    private var mBinding: SelectGitRepositoryFragmentBinding? = null
    private var mAdapterGit: SelectGitRepositoryAdapter? = SelectGitRepositoryAdapter(this)
    private var mService = createService(GitRepositoryApiDataSource::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.select_git_repository_fragment,
            container,
            false
        )

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        foo()
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        mBinding?.selectRepositoryFragmentRecyclerView?.layoutManager = linearLayoutManager

        mBinding?.selectRepositoryFragmentRecyclerView?.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        mBinding?.selectRepositoryFragmentRecyclerView?.adapter = mAdapterGit
    }

    @SuppressLint("CheckResult")
    private fun foo() {
        mService.getGitRepositories(
            page = 1
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isLoading(true) }
            .doAfterTerminate { isLoading(false) }
            .subscribe(
                { response ->
                    onSuccess(response)
                },
                { throwable ->
                    onError(throwable.localizedMessage)
                }
            )
    }

    private fun isLoading(boolean: Boolean) {
        println(boolean)
    }

    private fun onSuccess(response: GitRepositoryApiResponse) {
        convertResponseToCardDtoList(response)
    }

    private fun onError(string: String) {
        println(string)
    }

    private fun convertResponseToCardDtoList(gitRepositoryApiResponse: GitRepositoryApiResponse) {
        val cardDtoList = mutableListOf<GitRepositoryCardDto>()
        gitRepositoryApiResponse.items.forEach {
            cardDtoList.add(convertGitRepositoryDtoToGitRepositoryCardDto(it))
        }

        mAdapterGit?.replaceData(cardDtoList)
    }

    private fun convertGitRepositoryDtoToGitRepositoryCardDto(gitRepositoryDto: GitRepositoryDto): GitRepositoryCardDto {
        return GitRepositoryCardDto(
            gitRepositoryName = gitRepositoryDto.name,
            gitRepositoryDescription = gitRepositoryDto.description,
            forkQuantity = gitRepositoryDto.forks_count.toString(),
            starsQuantity = gitRepositoryDto.stargazers_count.toString(),
            userImageUrl = gitRepositoryDto.owner.avatar_url,
            userName = gitRepositoryDto.owner.login
        )
    }

    override fun onClick(ownerLogin: String, repositoryName: String) {
        findNavController().navigate(
            actionSelectRepositoryFragmentToSelectGitPullRequestFragment(
                ownerLogin,
                repositoryName
            )
        )
    }

}