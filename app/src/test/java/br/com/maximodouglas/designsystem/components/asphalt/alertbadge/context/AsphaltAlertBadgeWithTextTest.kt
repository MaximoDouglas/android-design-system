package br.com.maximodouglas.designsystem.components.asphalt.alertbadge.context

import org.junit.Before
import org.junit.Test

class AsphaltAlertBadgeWithTextTest : AsphaltAlertBadgeTest() {

    @Before
    fun `setup scenario`() {
        `when alert badge has text`()
    }

    @Test
    fun `test if text is set correctly`() {
        `assert alert badge text is set correctly`()
    }

    @Test
    fun `test if there is no click listeners`() {
        `assert alert badge has no click listeners`()
    }


}