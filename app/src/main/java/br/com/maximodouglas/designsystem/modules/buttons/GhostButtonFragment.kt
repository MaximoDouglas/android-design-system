package br.com.maximodouglas.designsystem.modules.buttons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.FragmentGhostButtonBinding
import br.com.maximodouglas.designsystem.modules.commons.ComponentFragmentNavigation

class GhostButtonFragment : Fragment(), ComponentFragmentNavigation {

    private var mBinding: FragmentGhostButtonBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_ghost_button,
            container,
            false
        )

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupGhostButtons()
    }

    private fun setupGhostButtons() {
        setupEnabledGhostButton()
        setupDisabledGhostButton()
    }

    private fun setupEnabledGhostButton() {
        mBinding?.gbDesignSystemFragmentEnabledGhostButton?.setText(
            getString(R.string.fragment_ghost_button_enabled_label)
        )

        mBinding?.gbDesignSystemFragmentEnabledGhostButton?.setOnClickListener {
            Toast.makeText(
                context,
                getString(R.string.fragment_ghost_button_disabled_click_text),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setupDisabledGhostButton() {
        mBinding?.gbDesignSystemFragmentDisabledGhostButton?.setText(
            getString(R.string.fragment_ghost_button_disabled_label)
        )

        mBinding?.gbDesignSystemFragmentDisabledGhostButton?.isEnabled = false
    }

    override fun getFragmentDestination(): Int {
        return R.id.fragmentGhostButton
    }

    override fun getFragmentName(): String {
        return FRAGMENT_NAME
    }

    companion object {
        const val FRAGMENT_NAME = "Ghost Button"

        fun newInstance(): GhostButtonFragment {
            val args = Bundle()

            return GhostButtonFragment().apply {
                arguments = args
            }
        }
    }
}
