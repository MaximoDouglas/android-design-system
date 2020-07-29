package br.com.argmax.design_systems.components.asphalt.ghostbutton.context

import org.junit.Before
import org.junit.Test

class AsphaltGhostButtonWithTextTest : AsphaltGhostButtonTest() {

    @Before
    fun `setup scenario`() {
        `when ghost button has text`()
    }

    @Test
    fun `test if text is ser correctly`() {
        `assert text is set correctly`()
    }

    @Test
    fun `test if button is enabled`() {
        `assert button is enabled`()
    }


}
