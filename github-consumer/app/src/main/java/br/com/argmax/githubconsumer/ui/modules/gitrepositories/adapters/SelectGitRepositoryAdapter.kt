package br.com.argmax.githubconsumer.ui.modules.gitrepositories.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.GitRepositoryCardViewHolderBinding
import br.com.argmax.githubconsumer.ui.components.repositorycard.dto.GitRepositoryCardDto
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.git_repository_card_view_holder.*

class SelectGitRepositoryAdapter() : Adapter<SelectGitRepositoryAdapter.GitRepositoryCardViewHolder>() {

    private var data: List<GitRepositoryCardDto> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GitRepositoryCardViewHolder {
        val gitRepositoryCardViewHolderBinding: GitRepositoryCardViewHolderBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.git_repository_card_view_holder,
                parent,
                false
            )

        return GitRepositoryCardViewHolder(gitRepositoryCardViewHolderBinding.root)
    }

    override fun onBindViewHolder(holder: GitRepositoryCardViewHolder, position: Int) {
        holder.updateData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun replaceData(list: List<GitRepositoryCardDto>) {
        list.let {
            data = it
            notifyDataSetChanged()
        }
    }

    inner class GitRepositoryCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        LayoutContainer {

        override val containerView: View?
            get() = itemView

        fun updateData(repositoryCardDto: GitRepositoryCardDto) {
            gitRepositoryCard.setRepositoryCardDto(repositoryCardDto)
        }
    }

}
