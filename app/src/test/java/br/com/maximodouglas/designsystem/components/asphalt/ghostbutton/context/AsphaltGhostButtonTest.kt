package br.com.maximodouglas.designsystem.components.asphalt.ghostbutton.context

import android.app.Activity
import br.com.maximodouglas.designsystem.components.BaseComponentUnitTest
import com.maximodouglas.mdskit.component.buttons.ghostbutton.MDGhostButton
import org.junit.Assert.*

abstract class AsphaltGhostButtonTest : BaseComponentUnitTest() {

    companion object {

        const val TEXT = "Lorem Ipsum é simplesmente uma simulação"

        const val ENABLED_BUTTON_FALSE = false


    }

    private var mAsphaltGhostButton: MDGhostButton? = null

    override fun setupComponent(activity: Activity) {
        mAsphaltGhostButton = MDGhostButton(activity)
    }

    fun `when ghost button has text`() {
        mAsphaltGhostButton?.setText(TEXT)
    }

    fun `when ghost button is disabled`() {
        mAsphaltGhostButton?.isEnabled = ENABLED_BUTTON_FALSE
    }

    fun `when ghost button has text and is disabled`() {
        mAsphaltGhostButton?.setText(TEXT)
        mAsphaltGhostButton?.isEnabled = ENABLED_BUTTON_FALSE
    }

    fun `assert text is set correctly`() {
        assertEquals(TEXT, mAsphaltGhostButton?.getText().toString())
    }

    fun `assert text is null or empty`() {
        assertTrue(mAsphaltGhostButton?.getText().isNullOrEmpty())
    }

    fun `assert button is enabled`() {
        assertTrue(mAsphaltGhostButton?.isEnabled ?: false)
    }

    fun `assert button is disabled`() {
        assertFalse(mAsphaltGhostButton?.isEnabled ?: false)
    }


}
