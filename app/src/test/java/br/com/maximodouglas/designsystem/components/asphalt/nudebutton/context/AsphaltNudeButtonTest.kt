package br.com.maximodouglas.designsystem.components.asphalt.nudebutton.context

import android.app.Activity
import br.com.maximodouglas.designsystem.components.BaseComponentUnitTest
import com.maximodouglas.mdskit.component.buttons.nudebutton.MDNudeButton
import org.junit.Assert.*

abstract class AsphaltNudeButtonTest : BaseComponentUnitTest() {

    companion object {

        private const val TEXT = "Lorem Ipsum é simplesmente uma simulação"

        private const val ENABLE_BUTTON_SET_FALSE = false

    }

    private var mAsphaltNudeButton: MDNudeButton? = null

    override fun setupComponent(activity: Activity) {
        mAsphaltNudeButton = MDNudeButton(activity)
    }

    fun `when nude button has text`() {
        mAsphaltNudeButton?.setText(TEXT)
    }

    fun `assert that text is set correctly`() {
        assertEquals(TEXT, mAsphaltNudeButton?.getText().toString())
    }

    fun `assert that nude button is enabled`() {
        assertTrue(mAsphaltNudeButton?.isEnabled ?: false)
    }

    fun `when nude button is disabled`() {
        mAsphaltNudeButton?.isEnabled = ENABLE_BUTTON_SET_FALSE
    }

    fun `assert that nude button is disabled`() {
        assertFalse(mAsphaltNudeButton?.isEnabled ?: false)
    }

    fun `assert that text is null or empty`() {
        assertTrue(mAsphaltNudeButton?.getText().isNullOrEmpty())
    }


}
