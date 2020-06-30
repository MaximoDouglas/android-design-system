package br.com.argmax.design_systems.components.asphalt.socialavatarbadge.context

import android.app.Activity
import android.view.View
import br.com.argmax.design_systems.components.BaseComponentUnitTest
import br.com.argmax.design_systems.components.asphalt.AsphaltSocialAvatarBadge
import org.junit.Assert.*

abstract class AsphaltSocialAvatarBadgeTest : BaseComponentUnitTest() {

    companion object {

        private val IMAGE_URL_LIST_WITH_ONE_URL = listOf("https://picsum.photos/200/300")

        private val IMAGE_URL_LIST_WITH_TWO_URL = listOf(
            "https://picsum.photos/200/300", "https://picsum.photos/300/400"
        )

        private const val TEXT_LABEL = "Lorem Ipsum é simplesmente uma simulação"
    }

    private var mAsphaltSocialAvatarBadge: AsphaltSocialAvatarBadge? = null

    override fun setupComponent(activity: Activity) {
        mAsphaltSocialAvatarBadge = AsphaltSocialAvatarBadge(activity)
    }

    fun `when social avatar badge has one url and label`() {
        mAsphaltSocialAvatarBadge?.setLabelAndImageUrlList(TEXT_LABEL, IMAGE_URL_LIST_WITH_ONE_URL)
    }

    fun `assert that text is set correctly`() {
        assertEquals(TEXT_LABEL, mAsphaltSocialAvatarBadge?.getLabelText().toString())
    }

    fun `assert that main image url is set correctly`() {
        assertEquals(IMAGE_URL_LIST_WITH_ONE_URL, mAsphaltSocialAvatarBadge?.getImageUrlList())
    }

    fun `when social avatar badge has two image urls and label`() {
        mAsphaltSocialAvatarBadge?.setLabelAndImageUrlList(TEXT_LABEL, IMAGE_URL_LIST_WITH_TWO_URL)
    }

    fun `assert that both main and secondary image url are set correctly`() {
        assertEquals(IMAGE_URL_LIST_WITH_TWO_URL, mAsphaltSocialAvatarBadge?.getImageUrlList())
    }

    fun `assert that main image is visible`() {
        assertTrue(mAsphaltSocialAvatarBadge?.isMainImageVisible() ?: false)
    }

}
