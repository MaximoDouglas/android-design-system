package br.com.argmax.design_systems.components.asphalt.alertbadge.context

import android.app.Activity
import android.view.View
import br.com.argmax.design_systems.components.BaseComponentUnitTest
import br.com.argmax.design_systems.components.asphalt.AsphaltAlertBadge
import org.junit.Assert.*

abstract class AsphaltAlertBadgeTest : BaseComponentUnitTest() {

    companion object {

        private const val TEXT: String = "Lorem Ipsum é simplesmente uma simulação"

        private val CLICK_LISTENER: View.OnClickListener = View.OnClickListener {}


    }

    private var mAsphaltAlertBadgeComponentView: AsphaltAlertBadge? = null

    override fun setupComponent(activity: Activity) {
        mAsphaltAlertBadgeComponentView =
            AsphaltAlertBadge(activity)
    }

    internal fun `when alert badge has text`() {
        mAsphaltAlertBadgeComponentView?.setText(TEXT)
    }

    internal fun `when alert badge has click listener`() {
        mAsphaltAlertBadgeComponentView?.setOnClickListener(CLICK_LISTENER)
    }

    internal fun `when alert badge has text and click listener`() {
        mAsphaltAlertBadgeComponentView?.setText(TEXT)
        mAsphaltAlertBadgeComponentView?.setOnClickListener(CLICK_LISTENER)
    }

    internal fun `assert alert badge text is set correctly`() {
        val actual = mAsphaltAlertBadgeComponentView?.getText()

        assertEquals(TEXT, actual)
    }

    internal fun `assert alert badge has click listeners`() {
        val actual = mAsphaltAlertBadgeComponentView?.hasOnClickListeners() ?: false

        assertTrue(actual)
    }

    internal fun `assert alert badge text is null or empty`() {
        val actual = mAsphaltAlertBadgeComponentView?.getText().isNullOrEmpty()

        assertTrue(actual)
    }

    internal fun `assert alert badge has no click listeners`() {
        val actual = mAsphaltAlertBadgeComponentView?.hasOnClickListeners() ?: false

        assertFalse(actual)
    }


}