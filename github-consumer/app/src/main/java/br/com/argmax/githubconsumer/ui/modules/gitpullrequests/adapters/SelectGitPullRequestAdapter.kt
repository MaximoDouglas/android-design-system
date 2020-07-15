package br.com.argmax.githubconsumer.ui.modules.gitpullrequests.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.GitPullRequestCardViewHolderBinding
import br.com.argmax.githubconsumer.ui.components.pullrequestcard.dtos.GitPullRequestCardDto
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.git_pull_request_card_view_holder.*

class SelectGitPullRequestAdapter() :
    Adapter<SelectGitPullRequestAdapter.GitPullRequestCardViewHolder>() {

    private var data: List<GitPullRequestCardDto> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GitPullRequestCardViewHolder {
        val gitPullRequestCardViewHolderBinding: GitPullRequestCardViewHolderBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.git_pull_request_card_view_holder,
                parent,
                false
            )

        return GitPullRequestCardViewHolder(gitPullRequestCardViewHolderBinding.root)
    }

    override fun onBindViewHolder(holder: GitPullRequestCardViewHolder, position: Int) {
        holder.updateData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun replaceData(list: List<GitPullRequestCardDto>) {
        list.let {
            data = it
            notifyDataSetChanged()
        }
    }

    inner class GitPullRequestCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        LayoutContainer {

        override val containerView: View?
            get() = itemView

        fun updateData(gitPullRequestCardDto: GitPullRequestCardDto) {
            gitPullRequestCard.setPullRequestCardDto(gitPullRequestCardDto)
        }
    }

}
