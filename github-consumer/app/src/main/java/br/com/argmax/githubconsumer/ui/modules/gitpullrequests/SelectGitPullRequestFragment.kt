package br.com.argmax.githubconsumer.ui.modules.gitpullrequests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.SelectGitPullRequestFragmentBinding
import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryApiResponse
import br.com.argmax.githubconsumer.service.ApiDataSource.Companion.createService
import br.com.argmax.githubconsumer.service.GitPullRequestApiDataSource
import br.com.argmax.githubconsumer.ui.modules.gitpullrequests.adapters.SelectGitPullRequestAdapter
import br.com.argmax.githubconsumer.ui.utils.NavigationArgumentKeys.KEY_OWNER_LOGIN
import br.com.argmax.githubconsumer.ui.utils.NavigationArgumentKeys.KEY_REPOSITORY_NAME
import br.com.argmax.githubconsumer.utils.FragmentUtils.bundleContainsKeys
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SelectGitPullRequestFragment : Fragment() {

    private var mBinding: SelectGitPullRequestFragmentBinding? = null
    private var mAdapter: SelectGitPullRequestAdapter? = SelectGitPullRequestAdapter()
    private var mService = createService(GitPullRequestApiDataSource::class.java)

    private var mOwnerLogin: String? = null
    private var mRepositoryName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        extractDataFromBundle(savedInstanceState)
        extractDataFromBundle(arguments)
    }

    private fun extractDataFromBundle(bundle: Bundle?) {
        val bundleContainsKeys = bundleContainsKeys(bundle, KEY_OWNER_LOGIN, KEY_REPOSITORY_NAME)

        if (bundleContainsKeys) {
            mOwnerLogin = bundle?.getString(KEY_OWNER_LOGIN)
            mRepositoryName = bundle?.getString(KEY_REPOSITORY_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.select_git_pull_request_fragment,
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

        mBinding?.selectGitPullRequestFragmentRecyclerView?.layoutManager = linearLayoutManager

        mBinding?.selectGitPullRequestFragmentRecyclerView?.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        mBinding?.selectGitPullRequestFragmentRecyclerView?.adapter = mAdapter
    }

    private fun foo() {
        mOwnerLogin?.let { ownerLogin ->
            mRepositoryName?.let { repository ->
                mService.getGitPullRequests(
                    owner = ownerLogin,
                    repository = repository
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
        }
    }

    private fun isLoading(boolean: Boolean) {
        println(boolean)
    }

    private fun onSuccess(response: GitRepositoryApiResponse) {
        println(response)
        //convertResponseToCardDtoList(response)
    }

    private fun onError(string: String) {
        println(string)
    }
}