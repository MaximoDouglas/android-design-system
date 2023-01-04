package br.com.maximodouglas.designsystem.modules.commons

import br.com.maximodouglas.designsystem.modules.alertbadge.AlertBadgeFragment
import br.com.maximodouglas.designsystem.modules.buttons.GhostButtonFragment
import br.com.maximodouglas.designsystem.modules.buttons.NudeButtonFragment
import br.com.maximodouglas.designsystem.modules.notificationbadge.NotificationBadgeFragment
import br.com.maximodouglas.designsystem.modules.socialinteraction.SocialInteractionFragment

fun getFragmentList(): List<ComponentFragmentNavigation> {
    return listOf(
        NudeButtonFragment.newInstance(),
        GhostButtonFragment.newInstance(),
        AlertBadgeFragment.newInstance(),
        NotificationBadgeFragment.newInstance(),
        SocialInteractionFragment.newInstance()
    ).sortedBy { it.getFragmentName() }
}
