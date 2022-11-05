package br.com.maximodouglas.designsystem.components.asphalt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.AsphaltGhostButtonBinding

class AsphaltGhostButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mAsphaltGhostButtonComponentViewBinding: AsphaltGhostButtonBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context), R.layout.asphalt_ghost_button, this, true
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
                R.drawable.asphalt_ghost_button_disabled_shape_black40
            }
        )
    }

    fun setText(text: String) {
        mAsphaltGhostButtonComponentViewBinding?.asphaltGhostButtonLabelTextView?.text = text
        mAsphaltGhostButtonComponentViewBinding?.executePendingBindings()
    }

    fun getText(): CharSequence? {
        return mAsphaltGhostButtonComponentViewBinding?.asphaltGhostButtonLabelTextView?.text
    }


}