package br.com.argmax.design_systems.components.asphalt.alertbadge

import br.com.argmax.design_systems.components.asphalt.alertbadge.context.AsphaltAlertBadgeWithClickListenerTest
import br.com.argmax.design_systems.components.asphalt.alertbadge.context.AsphaltAlertBadgeWithTextAndClickListenerTest
import br.com.argmax.design_systems.components.asphalt.alertbadge.context.AsphaltAlertBadgeWithTextTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AsphaltAlertBadgeWithTextTest::class,
    AsphaltAlertBadgeWithClickListenerTest::class,
    AsphaltAlertBadgeWithTextAndClickListenerTest::class
)
class AsphaltAlertBadgeSuiteTest