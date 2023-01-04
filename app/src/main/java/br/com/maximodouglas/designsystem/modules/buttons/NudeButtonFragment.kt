package br.com.maximodouglas.designsystem.modules.buttons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.FragmentNudeButtonBinding
import br.com.maximodouglas.designsystem.modules.commons.ComponentFragmentNavigation

class NudeButtonFragment : Fragment(), ComponentFragmentNavigation {

    private var binding: FragmentNudeButtonBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_nude_button,
            container,
            false
        )

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupNudeButtons()
    }

    private fun setupNudeButtons() {
        setupEnabledNudeButton()
        setupDisabledNudeButton()
    }

    private fun setupEnabledNudeButton() {
        binding?.asphaltDesignSystemFragmentEnabledNudeButton?.setText(
            getString(R.string.design_system_fragment_enabled_nude_button_label)
        )

        binding?.asphaltDesignSystemFragmentEnabledNudeButton?.setOnClickListener {
            Toast.makeText(
                context,
                getString(R.string.design_system_fragment_nude_button_click_toast_text),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setupDisabledNudeButton() {
        binding?.asphaltDesignSystemFragmentDisabledNudeButton?.setText(
            getString(R.string.design_system_fragment_disabled_nude_button_label)
        )

        binding?.asphaltDesignSystemFragmentDisabledNudeButton?.isEnabled = false
    }

    override fun getFragmentDestination(): Int {
        return R.id.fragmentNudeButton
    }

    override fun getFragmentName(): String {
        return FRAGMENT_NAME
    }

    companion object {
        const val FRAGMENT_NAME = "Nude Button"

        fun newInstance(): NudeButtonFragment {
            val args = Bundle()

            return NudeButtonFragment().apply {
                arguments = args
            }
        }
    }
}
