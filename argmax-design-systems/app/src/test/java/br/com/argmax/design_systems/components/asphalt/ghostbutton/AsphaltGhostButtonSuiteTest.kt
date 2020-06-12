package br.com.argmax.design_systems.components.asphalt.ghostbutton

import br.com.argmax.design_systems.components.asphalt.ghostbutton.context.AsphaltGhostButtonEnabledTest
import br.com.argmax.design_systems.components.asphalt.ghostbutton.context.AsphaltGhostButtonEnabledWithTextTest
import br.com.argmax.design_systems.components.asphalt.ghostbutton.context.AsphaltGhostButtonWithTextTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AsphaltGhostButtonEnabledTest::class,
    AsphaltGhostButtonWithTextTest::class,
    AsphaltGhostButtonEnabledWithTextTest::class
)
class AsphaltGhostButtonSuiteTest