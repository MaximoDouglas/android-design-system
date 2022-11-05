package br.com.maximodouglas.designsystem.components

import br.com.maximodouglas.designsystem.components.asphalt.alertbadge.AsphaltAlertBadgeSuiteTest
import br.com.maximodouglas.designsystem.components.asphalt.ghostbutton.AsphaltGhostButtonSuiteTest
import br.com.maximodouglas.designsystem.components.asphalt.notificationbadge.AsphaltNotificationBadgeSuiteTest
import br.com.maximodouglas.designsystem.components.asphalt.nudebutton.AsphaltNudeButtonSuiteTest
import br.com.maximodouglas.designsystem.components.asphalt.socialavatarbadge.AsphaltSocialAvatarBadgeSuiteTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AsphaltAlertBadgeSuiteTest::class,
    AsphaltGhostButtonSuiteTest::class,
    AsphaltNotificationBadgeSuiteTest::class,
    AsphaltNudeButtonSuiteTest::class,
    AsphaltSocialAvatarBadgeSuiteTest::class
)
class ComponentSuiteTest