package br.com.argmax.githubconsumer.ui.modules.gitrepositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.SelectGitRepositoryFragmentBinding
import br.com.argmax.githubconsumer.ui.injections.InjectionUseCase.provideGetGitRepositoryDtoUseCase
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.SelectGitRepositoryFragmentDirections.actionSelectRepositoryFragmentToSelectGitPullRequestFragment
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.SelectGitRepositoryViewModel.SelectGitRepositoryViewModelFactory
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.adapters.SelectGitRepositoryAdapter
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.converters.RepositoryConverter.convertDtoListToCardDtoList
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.listeners.OnGitRepositoryClickListener
import br.com.argmax.githubconsumer.ui.utils.EndlessRecyclerOnScrollListener

class SelectGitRepositoryFragment : Fragment(), OnGitRepositoryClickListener {

    private var mBinding: SelectGitRepositoryFragmentBinding? = null

    private var mViewModel: SelectGitRepositoryViewModel? = null
    private var mAdapter: SelectGitRepositoryAdapter? = SelectGitRepositoryAdapter(this)

    private var mApiRequestPage: Int = 1

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
        setupViewModel()
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        mBinding?.selectRepositoryFragmentRecyclerView?.layoutManager = linearLayoutManager

        mBinding?.selectRepositoryFragmentRecyclerView?.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        mBinding?.selectRepositoryFragmentRecyclerView?.adapter = mAdapter
        mBinding?.selectRepositoryFragmentRecyclerView?.addOnScrollListener(object :
            EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                mApiRequestPage++
                loadData()
            }
        })
    }

    private fun setupViewModel() {
        mViewModel = ViewModelProvider(
            this,
            SelectGitRepositoryViewModelFactory(provideGetGitRepositoryDtoUseCase())
        ).get(SelectGitRepositoryViewModel::class.java)

        mViewModel?.gitRepositoryApiResponseLiveData?.observe(
            viewLifecycleOwner,
            Observer { gitRepositoryDto ->
                val gitRepositoryDtoList = convertDtoListToCardDtoList(gitRepositoryDto)
                mAdapter?.addData(gitRepositoryDtoList)
            })

        loadData()
    }

    private fun loadData() {
        mViewModel?.getGitRepositoryApiResponse(mApiRequestPage)
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