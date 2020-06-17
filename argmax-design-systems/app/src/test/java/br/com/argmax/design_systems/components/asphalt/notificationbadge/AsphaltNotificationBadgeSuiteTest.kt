package br.com.argmax.design_systems.components.asphalt.notificationbadge

import br.com.argmax.design_systems.components.asphalt.notificationbadge.context.AsphaltNotificationBadgeInvalidQuantityTest
import br.com.argmax.design_systems.components.asphalt.notificationbadge.context.AsphaltNotificationBadgeNoQuantityTest
import br.com.argmax.design_systems.components.asphalt.notificationbadge.context.AsphaltNotificationBadgeValidQuantityTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AsphaltNotificationBadgeValidQuantityTest::class,
    AsphaltNotificationBadgeInvalidQuantityTest::class,
    AsphaltNotificationBadgeNoQuantityTest::class
)
class AsphaltNotificationBadgeSuiteTest
