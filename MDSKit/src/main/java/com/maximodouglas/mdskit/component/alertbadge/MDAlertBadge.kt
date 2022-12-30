package com.maximodouglas.mdskit.component.alertbadge

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater.from
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil.inflate
import com.maximodouglas.mdskit.R
import com.maximodouglas.mdskit.databinding.AlertBadgeBinding

class MDAlertBadge @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var binding: AlertBadgeBinding = inflate(
        from(context),
        R.layout.alert_badge,
        this,
        true
    )

    fun setTitleText(text: String) {
        binding.tvAlertBadgeTitle.text = text
    }

    fun getTitleText(): CharSequence? {
        return binding.tvAlertBadgeTitle.text
    }

    fun setButtonText(text: String) {
        binding.tvAlertBadgeNudeButton.text = text
    }

    fun getButtonText(): CharSequence? {
        return binding.tvAlertBadgeNudeButton.text
    }

    override fun setOnClickListener(onClickListener: OnClickListener?) {
        onClickListener?.let {
            binding.tvAlertBadgeNudeButton.setOnClickListener(onClickListener)
        }
    }

    override fun hasOnClickListeners(): Boolean {
        return binding.tvAlertBadgeNudeButton.hasOnClickListeners()
    }
}
