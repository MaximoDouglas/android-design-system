package br.com.argmax.design_systems.components.asphalt.ghostbutton.context

import org.junit.Test

class AsphaltGhostButtonDisabledTest: AsphaltGhostButtonTest() {

    @Test
    fun `test if button is disabled`() {
        `when ghost button is disabled`()
        `assert button is disabled`()
    }

    @Test
    fun `test if text is null or empty`() {
        `when ghost button is disabled`()
        `assert text is null or empty`()
    }


}
