package br.com.argmax.design_systems.app.components.asphalt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import br.com.argmax.design_systems.app.extentions.setCircularImageByUrlWithBorder
import br.com.argmax.design_systems.databinding.AsphaltSocialAvatarBadgeComponentViewBinding

class AsphaltSocialAvatarBadgeComponentView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mBinding: AsphaltSocialAvatarBadgeComponentViewBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            br.com.argmax.design_systems.R.layout.asphalt_social_avatar_badge_component_view,
            this,
            true
        )

    fun setImageUrls(imageUrls: List<String>, badgeLabel: String): Boolean {
        return if (imageUrls.isEmpty()) {
            false
        } else {
            setupImageViewResources(imageUrls)
            setupLabelText(badgeLabel)

            mBinding?.executePendingBindings()
            return true
        }
    }

    private fun setupImageViewResources(imageUrls: List<String>) {
        val mainImageUrl = imageUrls[0]

        mBinding?.asphaltSocialAvatarBadgeMainImageView?.setCircularImageByUrlWithBorder(mainImageUrl)

        if (imageUrls.size > 1) {
            val secondaryImageVisibility = View.VISIBLE
            val secondaryImageUrl        = imageUrls[1]

            mBinding?.asphaltSocialAvatarBadgeSecondaryImageView?.visibility =
                secondaryImageVisibility

            mBinding?.asphaltSocialAvatarBadgeSecondaryImageView?.setCircularImageByUrlWithBorder(
                secondaryImageUrl
            )
        }
    }

    private fun setupLabelText(badgeLabel: String) {
        mBinding?.asphaltSocialAvatarBadgeLabelTextView?.text = badgeLabel
    }


}