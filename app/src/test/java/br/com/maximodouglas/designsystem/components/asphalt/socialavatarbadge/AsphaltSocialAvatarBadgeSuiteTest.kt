package br.com.maximodouglas.designsystem.components.asphalt.socialavatarbadge

import br.com.maximodouglas.designsystem.components.asphalt.socialavatarbadge.context.*
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AsphaltSocialAvatarBadgeWithEmptyUrlListAndLabelTest::class,
    AsphaltSocialAvatarBadgeWithOneImageUrlAndLabelTest::class,
    AsphaltSocialAvatarBadgeWithTwoImageUrlAndLabelTest::class
)
class AsphaltSocialAvatarBadgeSuiteTest
