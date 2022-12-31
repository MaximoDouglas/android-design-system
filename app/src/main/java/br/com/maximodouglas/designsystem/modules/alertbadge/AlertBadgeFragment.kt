package br.com.maximodouglas.designsystem.modules.alertbadge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.FragmentAlertBadgeBinding
import br.com.maximodouglas.designsystem.modules.commons.FragmentNavigationDirection
import com.maximodouglas.mdskit.utils.showToast

class AlertBadgeFragment : Fragment(), FragmentNavigationDirection {

    private var binding: FragmentAlertBadgeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_alert_badge,
            container,
            false
        )

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAlertBadge()
    }

    private fun setupAlertBadge() {
        binding?.asphaltDesignSystemFragmentAlertBadge?.apply {
            setTitleText(getString(R.string.alert_badge_title))
            setOnClickListener {
                context?.showToast(getString(R.string.alert_badge_click_toast))
            }
        }
    }

    override fun getFragmentDestination(): Int {
        return R.id.fragmentAlertBadge
    }

    override fun getFragmentName(): String {
        return FRAGMENT_NAME
    }

    companion object {
        const val FRAGMENT_NAME = "Alert Badge"

        fun newInstance(): AlertBadgeFragment {
            val args = Bundle()

            return AlertBadgeFragment().apply {
                arguments = args
            }
        }
    }
}
