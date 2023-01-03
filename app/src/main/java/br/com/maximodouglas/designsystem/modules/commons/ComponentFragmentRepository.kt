package br.com.maximodouglas.designsystem.modules.commons

import br.com.maximodouglas.designsystem.modules.alertbadge.AlertBadgeFragment
import br.com.maximodouglas.designsystem.modules.buttons.GhostButtonFragment
import br.com.maximodouglas.designsystem.modules.buttons.NudeButtonFragment

fun getFragmentList(): List<FragmentNavigationDirection> {
    return listOf(
        NudeButtonFragment.newInstance(),
        GhostButtonFragment.newInstance(),
        AlertBadgeFragment.newInstance()
    )
}
