package br.com.argmax.design_systems.app.components.asphalt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
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

    fun setText(text: String) {
        mAsphaltNudeButtonComponentViewBinding?.asphaltNudeButtonLabelTextView?.text = text
        mAsphaltNudeButtonComponentViewBinding?.executePendingBindings()
    }


}