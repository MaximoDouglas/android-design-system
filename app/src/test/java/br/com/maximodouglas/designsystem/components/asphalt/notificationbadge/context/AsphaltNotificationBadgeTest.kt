package br.com.maximodouglas.designsystem.components.asphalt.notificationbadge.context

import android.app.Activity
import br.com.maximodouglas.designsystem.components.BaseComponentUnitTest
import com.maximodouglas.mdskit.component.notificationbadge.MDNotificationBadge
import org.junit.Assert.*
import kotlin.random.Random.Default.nextInt

abstract class AsphaltNotificationBadgeTest : BaseComponentUnitTest() {

    companion object {

        val VALID_QUANTITY = nextInt(from = 0, until = 99)

        val INVALID_QUANTITY =
            nextInt(from = Int.MIN_VALUE, until = Int.MAX_VALUE).takeUnless { number ->
                number in 0..99
            } ?: -1


    }

    private var mAsphaltNotificationBadge: MDNotificationBadge? = null

    override fun setupComponent(activity: Activity) {
        mAsphaltNotificationBadge = MDNotificationBadge(activity)
    }

    fun `when component has valid quantity`() {
        mAsphaltNotificationBadge?.setQuantity(VALID_QUANTITY)
    }

    fun `when component has invalid quantity`() {
        mAsphaltNotificationBadge?.setQuantity(INVALID_QUANTITY)
    }

    fun `when component has no quantity`() {}

    fun `assert has quantity`() {
        assertTrue(mAsphaltNotificationBadge?.hasQuantity() ?: false)
    }

    fun `assert quantity is set correctly`() {
        assertEquals(VALID_QUANTITY, mAsphaltNotificationBadge?.getQuantity().toString().toInt())
    }

    fun `assert quantity is not set`() {
        assertFalse(mAsphaltNotificationBadge?.hasQuantity() ?: false)
    }

    fun `assert quantity is null or empty`() {
        assertTrue(mAsphaltNotificationBadge?.getQuantity().isNullOrEmpty())
    }


}
