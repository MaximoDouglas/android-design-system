package br.com.maximodouglas.designsystem.modules.selectcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.FragmentSelectComponentBinding
import br.com.maximodouglas.designsystem.modules.commons.getFragmentList

class SelectComponentFragment : Fragment() {

    private var binding: FragmentSelectComponentBinding? = null

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

        setupAsphaltButton()
    }

    private fun setupAsphaltButton() {
        binding?.run {
            gbSelectFirstComponent.also {
                with(getFragmentList()[0]) {
                    it.setText(getFragmentName())

                    it.setOnClickListener {
                        findNavController().navigate(getFragmentDestination())
                    }
                }
            }

            gbSelectSecondComponent.also {
                with(getFragmentList()[1]) {
                    it.setText(getFragmentName())

                    it.setOnClickListener {
                        findNavController().navigate(getFragmentDestination())
                    }
                }
            }

            gbSelectThidComponent.also {
                with(getFragmentList()[2]) {
                    it.setText(getFragmentName())

                    it.setOnClickListener {
                        findNavController().navigate(getFragmentDestination())
                    }
                }
            }
        }
    }
}
