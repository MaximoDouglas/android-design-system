package br.com.maximodouglas.designsystem.modules.buttons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.AsphaltDesignSystemFragmentBinding
import com.maximodouglas.mdskit.utils.showToast

class NudeButtonFragment : Fragment() {

    private var mBinding: AsphaltDesignSystemFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.asphalt_design_system_fragment,
            container,
            false
        )

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAlertBadge()
        setupNotificationBadges()
        setupSocialAvatarBadges()
        setupNudeButtons()
        setupGhostButtons()
    }

    private fun setupAlertBadge() {
        mBinding?.asphaltDesignSystemFragmentAlertBadge?.apply {
            setTitleText(getString(R.string.alert_badge_title))
            setOnClickListener {
                context?.showToast(getString(R.string.alert_badge_click_toast))
            }
        }
    }

    private fun setupNotificationBadges() {
        val oneDigitQuantity = 1
        val twoDigitQuantity = 99

        mBinding?.asphaltDesignSystemFragmentNotificationBadgeOneDigit?.setQuantity(oneDigitQuantity)
        mBinding?.asphaltDesignSystemFragmentNotificationBadgeTwoDigit?.setQuantity(twoDigitQuantity)
    }

    private fun setupSocialAvatarBadges() {
        val picsumImageUrl200x200 = "https://picsum.photos/200"
        val picsumImageUrl300x300 = "https://picsum.photos/300"

        val oneImageUrlList = listOf(picsumImageUrl200x200)
        mBinding?.asphaltDesignSystemFragmentSocialAvatarBadgeOneImage?.setLabelAndImageUrlList(
            getString(R.string.design_system_fragment_social_avatar_one_image_badge),
            oneImageUrlList
        )

        val twoImageUrlList = listOf(picsumImageUrl200x200, picsumImageUrl300x300)
        mBinding?.asphaltDesignSystemFragmentSocialAvatarBadgeTwoImages?.setLabelAndImageUrlList(
            getString(R.string.design_system_fragment_social_avatar_two_image_badge),
            twoImageUrlList
        )
    }

    private fun setupNudeButtons() {
        setupEnabledNudeButton()
        setupDisabledNudeButton()
    }

    private fun setupEnabledNudeButton() {
        mBinding?.asphaltDesignSystemFragmentEnabledNudeButton?.setText(
            getString(R.string.design_system_fragment_enabled_nude_button_label)
        )

        mBinding?.asphaltDesignSystemFragmentEnabledNudeButton?.setOnClickListener {
            Toast.makeText(
                context,
                getString(R.string.design_system_fragment_nude_button_click_toast_text),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setupDisabledNudeButton() {
        mBinding?.asphaltDesignSystemFragmentDisabledNudeButton?.setText(
            getString(R.string.design_system_fragment_disabled_nude_button_label)
        )

        mBinding?.asphaltDesignSystemFragmentDisabledNudeButton?.isEnabled = false
    }

    private fun setupGhostButtons() {
        setupEnabledGhostButton()
        setupDisabledGhostButton()
    }

    private fun setupEnabledGhostButton() {
        mBinding?.asphaltDesignSystemFragmentEnabledGhostButton?.setText(
            getString(R.string.design_system_fragment_enabled_ghost_button_label)
        )

        mBinding?.asphaltDesignSystemFragmentEnabledGhostButton?.setOnClickListener {
            Toast.makeText(
                context,
                getString(R.string.design_system_fragment_ghost_button_click_toast_text),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setupDisabledGhostButton() {
        mBinding?.asphaltDesignSystemFragmentDisabledGhostButton?.setText(
            getString(R.string.design_system_fragment_disabled_ghost_button_label)
        )

        mBinding?.asphaltDesignSystemFragmentDisabledGhostButton?.isEnabled = false
    }
}
