package br.com.maximodouglas.designsystem.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.SocialAvatarBadgeBinding
import br.com.maximodouglas.designsystem.extentions.setCircularImageByUrlWithBorder

class SocialAvatarBadge @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var imageUrlsList: MutableList<String> = mutableListOf()

    private var binding: SocialAvatarBadgeBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.social_avatar_badge,
            this,
            true
        )

    fun setLabelAndImageUrlList(badgeLabel: String, imageUrls: List<String>) {
        setupLabelText(badgeLabel)

        if (imageUrls.isEmpty()) {
            showImages(false, false)
        } else {
            setupImageViewResources(imageUrls)
        }
    }

    private fun setupImageViewResources(imageUrls: List<String>) {
        imageUrlsList = imageUrls.toMutableList()

        binding.apply {
            with(imageUrlsList) {
                ivSocialAvatarBadgeMain.setCircularImageByUrlWithBorder(
                    get(MAIN_IMAGE_URL_LIST_INDEX)
                )

                if (this.size > SECONDARY_IMAGE_URL_LIST_INDEX) {
                    ivSocialAvatarBadgeSecondary.setCircularImageByUrlWithBorder(
                        get(SECONDARY_IMAGE_URL_LIST_INDEX)
                    )
                }
            }
        }
    }

    private fun setupLabelText(badgeLabel: String) {
        binding.tvSocialAvatarBadgeLabel.text = badgeLabel
    }

    fun getLabelText(): CharSequence? {
        return binding.tvSocialAvatarBadgeLabel.text
    }

    fun getImageUrlList(): List<String> {
        return imageUrlsList
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun showImages(showMainImage: Boolean, showSecondaryImage: Boolean) {
        with(binding) {
            ivSocialAvatarBadgeMain.visibility =
                View.GONE.takeUnless { showMainImage } ?: View.VISIBLE

            ivSocialAvatarBadgeSecondary.visibility =
                View.GONE.takeUnless { showSecondaryImage } ?: View.VISIBLE
        }
    }

    fun isMainImageVisible(): Boolean {
        return binding.ivSocialAvatarBadgeMain.visibility == View.VISIBLE
    }

    fun isSecondaryImageVisible(): Boolean {
        return binding.ivSocialAvatarBadgeSecondary.visibility == View.VISIBLE
    }

    companion object {
        private const val MAIN_IMAGE_URL_LIST_INDEX = 0
        private const val SECONDARY_IMAGE_URL_LIST_INDEX = 1
    }
}
