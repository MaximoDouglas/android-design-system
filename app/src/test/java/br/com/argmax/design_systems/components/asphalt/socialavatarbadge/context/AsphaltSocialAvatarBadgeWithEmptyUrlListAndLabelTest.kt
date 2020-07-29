package br.com.argmax.design_systems.components.asphalt.socialavatarbadge.context

import org.junit.Before
import org.junit.Test

class AsphaltSocialAvatarBadgeWithEmptyUrlListAndLabelTest : AsphaltSocialAvatarBadgeTest() {

    @Before
    fun `setup scenario`() {
        `when social avatar badge has empty image url list and label`()
    }

    @Test
    fun `test if label text is set correctly`() {
        `assert that text is set correctly`()
    }

    @Test
    fun `test if main image is not visible`() {
        `assert that main image is not visible`()
    }

    @Test
    fun `test if secondary image is not visible`() {
        `assert that secondary image is not visible`()
    }

}
