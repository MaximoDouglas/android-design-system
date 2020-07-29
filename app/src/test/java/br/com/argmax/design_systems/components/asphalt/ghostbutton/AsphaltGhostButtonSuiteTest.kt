package br.com.argmax.design_systems.components.asphalt.ghostbutton

import br.com.argmax.design_systems.components.asphalt.ghostbutton.context.AsphaltGhostButtonDisabledTest
import br.com.argmax.design_systems.components.asphalt.ghostbutton.context.AsphaltGhostButtonDisabledWithTextTest
import br.com.argmax.design_systems.components.asphalt.ghostbutton.context.AsphaltGhostButtonWithTextTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AsphaltGhostButtonDisabledTest::class,
    AsphaltGhostButtonWithTextTest::class,
    AsphaltGhostButtonDisabledWithTextTest::class
)
class AsphaltGhostButtonSuiteTest