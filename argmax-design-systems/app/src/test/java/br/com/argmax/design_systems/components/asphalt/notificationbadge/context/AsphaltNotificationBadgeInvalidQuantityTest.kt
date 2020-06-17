package br.com.argmax.design_systems.components.asphalt.notificationbadge.context

import org.junit.Before
import org.junit.Test

class AsphaltNotificationBadgeInvalidQuantityTest: AsphaltNotificationBadgeTest() {

    @Before
    fun `setup scenario`() {
        `when component has invalid quantity`()
    }

    @Test
    fun `test if has no quantity`() {
        `assert quantity is not set`()
    }

    @Test
    fun `test if quantity is null or empty`(){
        `assert quantity is null or empty`()
    }


}
