package br.com.argmax.design_systems.components.asphalt.socialavatarbadge.context

import android.app.Activity
import br.com.argmax.design_systems.components.BaseComponentUnitTest
import br.com.argmax.design_systems.components.asphalt.AsphaltSocialAvatarBadge

abstract class AsphaltSocialAvatarBadgeTest : BaseComponentUnitTest() {

    companion object {

        private val IMAGE_URL_LIST_WITH_ONE_VALID_URL = listOf("https://picsum.photos/200/300")

        private const val TEXT_LABEL = "Lorem Ipsum é simplesmente uma simulação"

    }

    private var mAsphaltSocialAvatarBadge: AsphaltSocialAvatarBadge? = null

    override fun setupComponent(activity: Activity) {
        mAsphaltSocialAvatarBadge = AsphaltSocialAvatarBadge(activity)
    }

    fun `when social avatar badge has one valid url and label test`() {
        mAsphaltSocialAvatarBadge?.setLabelAndImageUrlList(IMAGE_URL_LIST_WITH_ONE_VALID_URL, TEXT_LABEL)
    }

}
