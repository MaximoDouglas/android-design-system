package br.com.argmax.design_systems.components.asphalt

import android.app.Activity
import android.view.View
import br.com.argmax.design_systems.components.BaseComponentUnitTest
import org.junit.Assert.*

class AsphaltAlertBadgeComponentViewTest : BaseComponentUnitTest() {

    companion object {

        private const val TEXT: String = "Lorem Ipsum é simplesmente uma simulação"

        private val CLICK_LISTENER: View.OnClickListener = View.OnClickListener {}


    }

    private var asphaltAlertBadgeComponentView: AsphaltAlertBadgeComponentView? = null

    override fun setupComponent(activity: Activity) {
        asphaltAlertBadgeComponentView = AsphaltAlertBadgeComponentView(activity)
    }

    internal fun `when alert badge has text`() {
        asphaltAlertBadgeComponentView?.setText(TEXT)
    }

    internal fun `when alert badge has click listener`() {
        asphaltAlertBadgeComponentView?.setOnClickListener(CLICK_LISTENER)
    }

    internal fun `when alert badge has text and click listener`() {
        asphaltAlertBadgeComponentView?.setText(TEXT)
        asphaltAlertBadgeComponentView?.setOnClickListener(CLICK_LISTENER)
    }

    internal fun `test if alert badge text is set correctly`() {
        val actual = asphaltAlertBadgeComponentView?.getText()

        assertEquals(TEXT, actual)
    }

    internal fun `test if alert badge has click listeners`() {
        val actual = asphaltAlertBadgeComponentView?.hasOnClickListeners() ?: false

        assertTrue(actual)
    }

    internal fun `test if alert badge text is null or empty`() {
        val actual = asphaltAlertBadgeComponentView?.getText().isNullOrEmpty()

        assertTrue(actual)
    }

    internal fun `test if alert badge has no click listeners`() {
        val actual = asphaltAlertBadgeComponentView?.hasOnClickListeners() ?: false

        assertFalse(actual)
    }


}