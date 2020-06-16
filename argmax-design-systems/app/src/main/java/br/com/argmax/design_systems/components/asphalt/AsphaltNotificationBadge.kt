package br.com.argmax.design_systems.components.asphalt

import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import br.com.argmax.design_systems.R
import br.com.argmax.design_systems.databinding.AsphaltNotificationBadgeBinding

class AsphaltNotificationBadge @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mBinding: AsphaltNotificationBadgeBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.asphalt_notification_badge,
            this,
            true
        )

    fun setQuantity(quantity: Int): Boolean {
        return if (isValidQuantity(quantity)) {
            updateView(quantity)
            true
        } else {
            false
        }
    }

    private fun isValidQuantity(quantity: Int): Boolean {
        return quantity in 0..99
    }

    private fun updateView(quantity: Int) {
        val params = mBinding?.asphaltDesignSystemNotificationBadgeTextView?.layoutParams
        val width  = 16
        val height = if (quantity in 0..9) 16 else 14

        params?.width  = convertPxToDp(width)
        params?.height = convertPxToDp(height)

        mBinding?.asphaltDesignSystemNotificationBadgeTextView?.text         = quantity.toString()
        mBinding?.asphaltDesignSystemNotificationBadgeTextView?.layoutParams = params
        mBinding?.executePendingBindings()
    }

    fun getQuantity(): CharSequence? {
        return mBinding?.asphaltDesignSystemNotificationBadgeTextView?.text
    }

    private fun convertPxToDp(pixelsSize: Int): Int {
        return (pixelsSize * context.resources.displayMetrics.densityDpi) / DisplayMetrics.DENSITY_DEFAULT
    }


}