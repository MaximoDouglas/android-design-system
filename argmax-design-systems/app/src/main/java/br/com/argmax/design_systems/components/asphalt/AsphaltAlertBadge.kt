package br.com.argmax.design_systems.components.asphalt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import br.com.argmax.design_systems.R
import br.com.argmax.design_systems.databinding.AsphaltAlertBadgeBinding

class AsphaltAlertBadge @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mBinding: AsphaltAlertBadgeBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context), R.layout.asphalt_alert_badge, this, true
        )

    fun setText(text: String) {
        mBinding?.asphaltDesignSystemFragmentAlertBadgeText?.text = text
    }

    fun getText(): String {
        return mBinding?.asphaltDesignSystemFragmentAlertBadgeText?.text.toString()
    }

    override fun setOnClickListener(onClickListener: OnClickListener?) {
        onClickListener?.let {
            mBinding?.asphaltDesignSystemFragmentAlertBadgeNudeButton?.setOnClickListener(
                onClickListener
            )
        }
    }

    override fun hasOnClickListeners(): Boolean {
        return mBinding?.asphaltDesignSystemFragmentAlertBadgeNudeButton?.hasOnClickListeners() ?: false
    }


}