package br.com.argmax.design_systems.app.modules.asphalt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.argmax.design_systems.R
import br.com.argmax.design_systems.databinding.AsphaltDesignSystemFragmentBinding

class AsphaltDesignSystemFragment : Fragment() {

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

        setupNotificationBadges()
        setupSocialAvatarBadges()
    }

    private fun setupNotificationBadges() {
        val oneDigitQuantity = 1
        val twoDigitQuantity = 99

        mBinding?.asphaltDesignSystemFragmentNotificationBadgeOneDigit?.setQuantity(oneDigitQuantity)
        mBinding?.asphaltDesignSystemFragmentNotificationBadgeTwoDigit?.setQuantity(twoDigitQuantity)
    }

    private fun setupSocialAvatarBadges() {
        val picsumImageUrl200x200 = "https://picsum.photos/200/200"
        val picsumImageUrl300x300 = "https://picsum.photos/300/300"

        val oneImageUrlList = listOf(picsumImageUrl200x200)
        mBinding?.asphaltDesignSystemFragmentSocialAvatarBadgeOneImage?.setImageUrls(
            oneImageUrlList,
            getString(R.string.asphalt_design_system_fragment_social_avatar_one_image_badge)
        )

        val twoImageUrlList = listOf(picsumImageUrl200x200, picsumImageUrl300x300)
        mBinding?.asphaltDesignSystemFragmentSocialAvatarBadgeTwoImages?.setImageUrls(
            twoImageUrlList,
            getString(R.string.asphalt_design_system_fragment_social_avatar_two_image_badge)
        )
    }


}