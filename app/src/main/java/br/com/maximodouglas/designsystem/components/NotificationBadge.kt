package br.com.maximodouglas.designsystem.components.asphalt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.NotificationBadgeBinding

class AsphaltNotificationBadge @JvmOverloads constructor(
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
        isValidQuantity(quantity).also {
            binding.tvNotificationBadge.text = quantity.toString()
        }
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
