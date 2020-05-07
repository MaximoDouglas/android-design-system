package br.com.argmax.design_systems.app.components.asphalt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import br.com.argmax.design_systems.R
import br.com.argmax.design_systems.databinding.AsphaltNotificationBadgeComponentViewBinding

class AsphaltNotificationBadgeComponentView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mBinding: AsphaltNotificationBadgeComponentViewBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.asphalt_notification_badge_component_view,
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
        val layoutWidth  = 16
        val layoutHeight = if (quantity in 0..9) 16 else 12

        mBinding?.asphaltDesignSystemNotificationBadgeTextView?.width  = layoutWidth
        mBinding?.asphaltDesignSystemNotificationBadgeTextView?.height = layoutHeight
        mBinding?.asphaltDesignSystemNotificationBadgeTextView?.text   = quantity.toString()
        mBinding?.executePendingBindings()
    }


}