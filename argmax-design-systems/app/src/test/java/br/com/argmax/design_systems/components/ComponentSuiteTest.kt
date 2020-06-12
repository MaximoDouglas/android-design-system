package br.com.argmax.design_systems.components

import br.com.argmax.design_systems.components.asphalt.alertbadge.AsphaltAlertBadgeSuiteTest
import br.com.argmax.design_systems.components.asphalt.ghostbutton.AsphaltGhostButtonSuiteTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AsphaltAlertBadgeSuiteTest::class,
    AsphaltGhostButtonSuiteTest::class
)
class ComponentSuiteTest