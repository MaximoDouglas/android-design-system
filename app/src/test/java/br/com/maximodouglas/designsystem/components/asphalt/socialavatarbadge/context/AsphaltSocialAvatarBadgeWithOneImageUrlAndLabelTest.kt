package br.com.maximodouglas.designsystem.components.asphalt.socialavatarbadge.context

import org.junit.Before
import org.junit.Test

class AsphaltSocialAvatarBadgeWithOneImageUrlAndLabelTest : AsphaltSocialAvatarBadgeTest() {

    @Before
    fun `setup scenario`() {
        `when social avatar badge has one url and label`()
    }

    @Test
    fun `test if social badge label text is set correctly`() {
        `assert that text is set correctly`()
    }

    @Test
    fun `test if social badge main image url is set correctly`() {
        `assert that main image url is set correctly`()
    }

    @Test
    fun `test if social badge main image is visible`() {
        `assert that main image is visible`()
    }

    @Test
    fun `test if social badge secondary image is not visible`() {
        `assert that secondary image is not visible`()
    }

}
