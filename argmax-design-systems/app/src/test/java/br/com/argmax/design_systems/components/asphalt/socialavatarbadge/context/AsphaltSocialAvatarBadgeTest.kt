package br.com.argmax.design_systems.components.asphalt.socialavatarbadge.context

import android.app.Activity
import br.com.argmax.design_systems.components.BaseComponentUnitTest
import br.com.argmax.design_systems.components.asphalt.AsphaltSocialAvatarBadge

abstract class AsphaltSocialAvatarBadgeTest : BaseComponentUnitTest() {

    private var mAsphaltSocialAvatarBadge: AsphaltSocialAvatarBadge? = null

    override fun setupComponent(activity: Activity) {
        mAsphaltSocialAvatarBadge = AsphaltSocialAvatarBadge(activity)
    }

}
