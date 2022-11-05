package br.com.maximodouglas.designsystem.components.asphalt.alertbadge.context

import org.junit.Before
import org.junit.Test

class AsphaltAlertBadgeWithTextAndClickListenerTest : AsphaltAlertBadgeTest() {

    @Before
    fun `setup scenario`() {
        `when alert badge has text`()
        `when alert badge has click listener`()
    }

    @Test
    fun `test if text is set correctly`() {
        `assert alert badge text is set correctly`()
    }

    @Test
    fun `test if there is click listener`() {
        `assert alert badge has click listeners`()
    }


}