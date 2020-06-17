package br.com.argmax.design_systems.components.asphalt.ghostbutton.context

import org.junit.Before
import org.junit.Test

class AsphaltGhostButtonDisabledWithTextTest: AsphaltGhostButtonTest() {

    @Before
    fun `setup scenario`() {
        `when ghost button has text`()
        `when ghost button is disabled`()
    }

    @Test
    fun `test if button is disabled`() {
        `assert button is disabled`()
    }

    @Test
    fun `test if text is set correctly`() {
        `assert text is set correctly`()
    }


}
