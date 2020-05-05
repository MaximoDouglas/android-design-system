package br.com.argmax.design_systems.components.asphalt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.argmax.design_systems.R
import br.com.argmax.design_systems.databinding.AsphaltAlertBadgeComponentViewBinding

class AsphaltAlertBadgeComponentView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mBinding: AsphaltAlertBadgeComponentViewBinding? = DataBindingUtil.inflate(
        LayoutInflater.from(context), R.layout.asphalt_alert_badge_component_view, this, true
    )

    init {
        setupNudeButton()
    }

    private fun setupNudeButton() {
        mBinding?.asphaltDesignSystemFragmentAlertBadgeNudeButton?.setOnClickListener {
            Toast.makeText(context, "Alert Badge Nude Button Clicked", Toast.LENGTH_LONG).show()
        }
    }

}