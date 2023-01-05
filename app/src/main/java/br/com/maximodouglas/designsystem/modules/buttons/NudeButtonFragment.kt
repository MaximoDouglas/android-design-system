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
        binding?.enabledNudeButton?.apply {
            setText(
                getString(R.string.fragment_nude_button_enabled_label)
            )

            setOnClickListener {
                Toast.makeText(
                    context,
                    getString(R.string.fragment_nude_button_click_text),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun setupDisabledNudeButton() {
        binding?.disabledNudeButton?.also {
            it.setText(
                getString(R.string.fragment_nude_button_disabled_label)
            )

            it.isEnabled = false
        }
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
