package br.com.argmax.design_systems.app.components.asphalt

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import br.com.argmax.design_systems.R
import br.com.argmax.design_systems.databinding.AsphaltNudeButtonComponentViewBinding

class AsphaltNudeButtonComponentView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mAsphaltNudeButtonComponentViewBinding: AsphaltNudeButtonComponentViewBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context), R.layout.asphalt_nude_button_component_view, this, true
        )

    init {
        onPressedListener()
    }

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

    @SuppressLint("ClickableViewAccessibility")
    private fun onPressedListener() {
        mAsphaltNudeButtonComponentViewBinding?.asphaltNudeButtonLabelTextView?.setOnTouchListener { textView, event ->
            if (this.isEnabled) {
                if (event.action == MotionEvent.ACTION_DOWN) {
                    (textView as TextView).setTextColor(
                        ContextCompat.getColor(context, R.color.RED40)
                    )
                }

                if (event.action == MotionEvent.ACTION_BUTTON_RELEASE) {
                    (textView as TextView).setTextColor(
                        ContextCompat.getColor(context, R.color.RED60)
                    )
                }

                textView.performClick()
            } else {
                true
            }
        }
    }


}