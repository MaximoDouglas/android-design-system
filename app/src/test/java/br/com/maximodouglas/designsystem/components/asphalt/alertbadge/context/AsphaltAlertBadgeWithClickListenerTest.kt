package br.com.maximodouglas.designsystem.components.asphalt.alertbadge.context

import org.junit.Before
import org.junit.Test

class AsphaltAlertBadgeWithClickListenerTest : AsphaltAlertBadgeTest() {

    @Before
    fun `setup scenario`() {
        `when alert badge has click listener`()
    }

    @Test
    fun `test if there is click listener`() {
        `assert alert badge has click listeners`()
    }

    @Test
    fun `test if there no text`() {
        `assert alert badge text is null or empty`()
    }


}