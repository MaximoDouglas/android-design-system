package com.maximodouglas.mdskit.component.socialinteraction

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.maximodouglas.mdskit.R
import com.maximodouglas.mdskit.databinding.SocialInteractionBinding
import com.maximodouglas.mdskit.utils.setCircularImageByUrlWithBorder

class MDSocialInteraction @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var imageUrlsList: MutableList<String> = mutableListOf()

    private var binding: SocialInteractionBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.social_interaction,
            this,
            true
        )

    fun setLabelAndImageUrlList(badgeLabel: String, imageUrls: List<String>) {
        setupLabelText(badgeLabel)

        if (imageUrls.isEmpty()) {
            showImages(showMainImage = false, showSecondaryImage = false)
        } else {
            setupImageViewResources(imageUrls)
        }
    }

    private fun setupLabelText(badgeLabel: String) {
        binding.tvSocialInteractionLabel.text = badgeLabel
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun showImages(showMainImage: Boolean, showSecondaryImage: Boolean) {
        with(binding) {
            ivSocialInteractionMain.visibility =
                View.GONE.takeUnless { showMainImage } ?: View.VISIBLE

            ivSocialInteractionSecondary.visibility =
                View.GONE.takeUnless { showSecondaryImage } ?: View.VISIBLE
        }
    }

    private fun setupImageViewResources(imageUrls: List<String>) {
        imageUrlsList = imageUrls.toMutableList()

        binding.apply {
            with(imageUrlsList) {
                ivSocialInteractionMain.setCircularImageByUrlWithBorder(
                    get(MAIN_IMAGE_URL_LIST_INDEX)
                )

                if (this.size > SECONDARY_IMAGE_URL_LIST_INDEX) {
                    ivSocialInteractionSecondary.setCircularImageByUrlWithBorder(
                        get(SECONDARY_IMAGE_URL_LIST_INDEX)
                    )
                }
            }
        }
    }

    fun getLabelText(): CharSequence? {
        return binding.tvSocialInteractionLabel.text
    }

    fun getImageUrlList(): List<String> {
        return imageUrlsList
    }

    fun isMainImageVisible(): Boolean {
        return binding.ivSocialInteractionMain.visibility == View.VISIBLE
    }

    fun isSecondaryImageVisible(): Boolean {
        return binding.ivSocialInteractionSecondary.visibility == View.VISIBLE
    }

    companion object {
        private const val MAIN_IMAGE_URL_LIST_INDEX = 0
        private const val SECONDARY_IMAGE_URL_LIST_INDEX = 1
    }
}
