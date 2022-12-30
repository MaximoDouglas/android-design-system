package br.com.maximodouglas.designsystem.components.asphalt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.AsphaltNudeButtonBinding

class AsphaltNudeButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mAsphaltNudeButtonComponentViewBinding: AsphaltNudeButtonBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.asphalt_nude_button,
            this,
            true
        )

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)

        mAsphaltNudeButtonComponentViewBinding?.asphaltNudeButtonLabelTextView?.setTextColor(
            if (enabled) {
                ContextCompat.getColor(context, R.color.RED60)
            } else {
                ContextCompat.getColor(context, R.color.BLACK40)
            }
        )
    }

    fun setText(text: String) {
        mAsphaltNudeButtonComponentViewBinding?.asphaltNudeButtonLabelTextView?.text = text
        mAsphaltNudeButtonComponentViewBinding?.executePendingBindings()
    }

    fun getText(): CharSequence? {
        return mAsphaltNudeButtonComponentViewBinding?.asphaltNudeButtonLabelTextView?.text
    }
}
