package br.com.argmax.design_systems.components.asphalt.nudebutton

import br.com.argmax.design_systems.components.asphalt.nudebutton.context.AsphaltNudeButtonDisabledTest
import br.com.argmax.design_systems.components.asphalt.nudebutton.context.AsphaltNudeButtonDisabledWithTextTest
import br.com.argmax.design_systems.components.asphalt.nudebutton.context.AsphaltNudeButtonWithTextTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AsphaltNudeButtonDisabledTest::class,
    AsphaltNudeButtonWithTextTest::class,
    AsphaltNudeButtonDisabledWithTextTest::class
)
class AsphaltNudeButtonSuiteTest
