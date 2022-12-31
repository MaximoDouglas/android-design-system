package br.com.maximodouglas.designsystem.modules.selectDesignSystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.SelectDesignSystemFragmentBinding
import br.com.maximodouglas.designsystem.modules.commons.getFragmentList

class SelectDesignSystemFragment : Fragment() {

    private var mBinding: SelectDesignSystemFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.select_design_system_fragment,
            container,
            false
        )

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAsphaltButton()
    }

    private fun setupAsphaltButton() {
        mBinding?.gbSelectFirstComponent?.also {
            with(getFragmentList()[0]) {
                it.setText(getFragmentName())

                it.setOnClickListener {
                    findNavController().navigate(getFragmentDestination())
                }
            }
        }

        mBinding?.gbSelectSecondComponent?.also {
            with(getFragmentList()[1]) {
                it.setText(getFragmentName())

                it.setOnClickListener {
                    findNavController().navigate(getFragmentDestination())
                }
            }
        }
    }
}
