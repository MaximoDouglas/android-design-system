package br.com.argmax.design_systems.app.components.asphalt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import br.com.argmax.design_systems.R
import br.com.argmax.design_systems.databinding.AsphaltGhostButtonComponentViewBinding

class AsphaltGhostButtonComponentView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mAsphaltGhostButtonComponentViewBinding: AsphaltGhostButtonComponentViewBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context), R.layout.asphalt_ghost_button_component_view, this, true
        )

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)

        mAsphaltGhostButtonComponentViewBinding?.asphaltGhostButtonLabelTextView?.setTextColor(
            if (enabled) {
                ContextCompat.getColor(context, R.color.GREEN50)
            } else {
                ContextCompat.getColor(context, R.color.BLACK40)
            }
        )

        mAsphaltGhostButtonComponentViewBinding?.asphaltGhostButtonContainer?.setBackgroundResource(
            if (enabled) {
                R.drawable.asphalt_ghost_button_background_selector
            } else {
                R.drawable.asphalt_black40_ghost_button_disabled_shape
            }
        )
    }

    fun setText(text: String) {
        mAsphaltGhostButtonComponentViewBinding?.asphaltGhostButtonLabelTextView?.text = text
        mAsphaltGhostButtonComponentViewBinding?.executePendingBindings()
    }


}