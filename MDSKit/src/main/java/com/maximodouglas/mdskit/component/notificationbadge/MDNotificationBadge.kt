package com.maximodouglas.mdskit.component.notificationbadge

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.maximodouglas.mdskit.R
import com.maximodouglas.mdskit.databinding.NotificationBadgeBinding

class MDNotificationBadge @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var binding: NotificationBadgeBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.notification_badge,
            this,
            true
        )

    fun setQuantity(quantity: Int) {
        binding.tvNotificationBadge.text =
            (quantity.takeIf { isValidQuantity(it) } ?: ZERO).toString()
    }

    private fun isValidQuantity(quantity: Int): Boolean {
        return quantity in ZERO..MAX_VALID_QUANTITY
    }

    fun getQuantity() = binding.tvNotificationBadge.text.toString()
        .takeUnless { it.isBlank() } ?: ZERO.toString()

    companion object {
        private const val ZERO = 0
        private const val MAX_VALID_QUANTITY = 99
    }
}
