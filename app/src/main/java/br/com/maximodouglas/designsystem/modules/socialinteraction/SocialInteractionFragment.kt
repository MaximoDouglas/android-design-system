package br.com.maximodouglas.designsystem.modules.socialinteraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.FragmentSocialInteractionBinding
import br.com.maximodouglas.designsystem.modules.commons.ComponentFragmentNavigation

class SocialInteractionFragment : Fragment(), ComponentFragmentNavigation {

    private var binding: FragmentSocialInteractionBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_social_interaction,
            container,
            false
        )

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSocialAvatarBadges()
    }

    private fun setupSocialAvatarBadges() {
        binding?.apply {
            socialAvatarBadgeOneImage.setLabelAndImageUrlList(
                getString(R.string.design_system_fragment_social_avatar_one_image_badge),
                listOf(PICSUM_URL_200)
            )

            socialAvatarBadgeTwoImages.setLabelAndImageUrlList(
                getString(R.string.design_system_fragment_social_avatar_two_image_badge),
                listOf(PICSUM_URL_200, PICSUM_URL_300)
            )
        }
    }

    override fun getFragmentDestination(): Int {
        return R.id.fragmentSocialInteractionFragment
    }

    override fun getFragmentName(): String {
        return FRAGMENT_NAME
    }

    companion object {
        const val FRAGMENT_NAME = "Social Interaction"
        private const val PICSUM_URL_200 = "https://picsum.photos/200"
        private const val PICSUM_URL_300 = "https://picsum.photos/300"

        fun newInstance(): SocialInteractionFragment {
            val args = Bundle()

            return SocialInteractionFragment().apply {
                arguments = args
            }
        }
    }
}
