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
import br.com.maximodouglas.designsystem.modules.commons.FragmentNavigationDirection

class NudeButtonFragment : Fragment(), FragmentNavigationDirection {

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

        setupNotificationBadges()
        setupSocialAvatarBadges()
        setupNudeButtons()
    }

    private fun setupNotificationBadges() {
        val oneDigitQuantity = 1
        val twoDigitQuantity = 99

        binding?.asphaltDesignSystemFragmentNotificationBadgeOneDigit?.setQuantity(oneDigitQuantity)
        binding?.asphaltDesignSystemFragmentNotificationBadgeTwoDigit?.setQuantity(twoDigitQuantity)
    }

    private fun setupSocialAvatarBadges() {
        val picsumImageUrl200x200 = "https://picsum.photos/200"
        val picsumImageUrl300x300 = "https://picsum.photos/300"

        val oneImageUrlList = listOf(picsumImageUrl200x200)
        binding?.asphaltDesignSystemFragmentSocialAvatarBadgeOneImage?.setLabelAndImageUrlList(
            getString(R.string.design_system_fragment_social_avatar_one_image_badge),
            oneImageUrlList
        )

        val twoImageUrlList = listOf(picsumImageUrl200x200, picsumImageUrl300x300)
        binding?.asphaltDesignSystemFragmentSocialAvatarBadgeTwoImages?.setLabelAndImageUrlList(
            getString(R.string.design_system_fragment_social_avatar_two_image_badge),
            twoImageUrlList
        )
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
