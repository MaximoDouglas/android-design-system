package br.com.argmax.design_systems.components.asphalt

import br.com.argmax.design_systems.components.asphalt.context.AsphaltAlertBadgeWithClickListenerTest
import br.com.argmax.design_systems.components.asphalt.context.AsphaltAlertBadgeWithTextTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AsphaltAlertBadgeWithTextTest::class,
    AsphaltAlertBadgeWithClickListenerTest::class
)
class AsphaltAlertBadgeSuiteTest