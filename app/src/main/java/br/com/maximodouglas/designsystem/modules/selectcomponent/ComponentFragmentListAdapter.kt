package br.com.maximodouglas.designsystem.modules.selectcomponent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.ViewHolderGhostButtonBinding
import br.com.maximodouglas.designsystem.modules.commons.ComponentFragmentNavigation

class ComponentsAdapter(
    private val componentFragmentList: List<ComponentFragmentNavigation>,
    private val componentSelectionListener: ComponentSelectionListener
) : RecyclerView.Adapter<ComponentsAdapter.ComponentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder {
        return ComponentViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.view_holder_ghost_button,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {
        holder.bind(componentFragmentList[position])
    }

    override fun getItemCount(): Int {
        return componentFragmentList.size
    }

    inner class ComponentViewHolder(
        private val binding: ViewHolderGhostButtonBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(fragment: ComponentFragmentNavigation) {
            binding.gbDesignSystemFragmentEnabledGhostButton.apply {
                setText(fragment.getFragmentName())

                setOnClickListener {
                    componentSelectionListener.onComponentSelection(fragment)
                }
            }
        }
    }
}

interface ComponentSelectionListener {
    fun onComponentSelection(selectedFragment: ComponentFragmentNavigation)
}
