package br.com.maximodouglas.designsystem.modules.notificationbadge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.FragmentNotificationBadgeBinding
import br.com.maximodouglas.designsystem.modules.commons.ComponentFragmentNavigation

class NotificationBadgeFragment : Fragment(), ComponentFragmentNavigation {

    private var binding: FragmentNotificationBadgeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_notification_badge,
            container,
            false
        )

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            notificationBadgeOneDigit.setQuantity(MIN_DIGIT_QUANTITY)
            notificationBadgeTwoDigit.setQuantity(MAX_DIGIT_QUANTITY)
        }
    }

    override fun getFragmentDestination(): Int {
        return R.id.fragmentNotificationBadgeFragment
    }

    override fun getFragmentName(): String {
        return FRAGMENT_NAME
    }

    companion object {
        const val FRAGMENT_NAME = "Notification Badge"
        private const val MIN_DIGIT_QUANTITY = 1
        private const val MAX_DIGIT_QUANTITY = 99

        fun newInstance(): NotificationBadgeFragment {
            val args = Bundle()

            return NotificationBadgeFragment().apply {
                arguments = args
            }
        }
    }
}
