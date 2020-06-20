package br.com.argmax.design_systems.components.asphalt.nudebutton.context

import android.app.Activity
import br.com.argmax.design_systems.components.BaseComponentUnitTest
import br.com.argmax.design_systems.components.asphalt.AsphaltNudeButton
import org.junit.Assert.assertEquals

abstract class AsphaltNudeButtonTest : BaseComponentUnitTest() {

    companion object {

        private const val TEXT = "Lorem Ipsum é simplesmente uma simulação"

    }

    private var mAsphaltNudeButton: AsphaltNudeButton? = null

    override fun setupComponent(activity: Activity) {
        mAsphaltNudeButton = AsphaltNudeButton(activity)
    }

    fun `when nude button has text`() {
        mAsphaltNudeButton?.setText(TEXT)
    }

    fun `assert that text is set correctly`() {
        assertEquals(TEXT, mAsphaltNudeButton?.getText().toString())
    }

}
