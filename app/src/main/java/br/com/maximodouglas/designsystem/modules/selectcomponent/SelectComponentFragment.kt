package br.com.maximodouglas.designsystem.modules.selectcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.FragmentSelectComponentBinding
import br.com.maximodouglas.designsystem.modules.commons.FragmentNavigationDirection
import br.com.maximodouglas.designsystem.modules.commons.getFragmentList

class SelectComponentFragment : Fragment(), ComponentSelectionListener {

    private var binding: FragmentSelectComponentBinding? = null
    private val componentListAdapter = ComponentsAdapter(getFragmentList(), this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_select_component,
            container,
            false
        )

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupComponentListRecyclerView()
    }

    private fun setupComponentListRecyclerView() {
        binding?.rvComponentList?.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = componentListAdapter
        }
    }

    override fun onComponentSelection(selectedFragment: FragmentNavigationDirection) {
        findNavController().navigate(selectedFragment.getFragmentDestination())
    }
}
