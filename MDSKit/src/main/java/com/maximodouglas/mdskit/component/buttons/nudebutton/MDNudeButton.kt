package com.maximodouglas.mdskit.component.buttons.nudebutton

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.maximodouglas.mdskit.R
import com.maximodouglas.mdskit.databinding.NudeButtonBinding

class MDNudeButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var binding: NudeButtonBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.nude_button,
            this,
            true
        )

    override fun setEnabled(isEnabled: Boolean) {
        super.setEnabled(isEnabled)

        binding.tvNudeButtonLabel.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.md_red60.takeIf { isEnabled } ?: R.color.md_black40
            )
        )
    }

    fun setText(text: String) {
        binding.tvNudeButtonLabel.text = text
    }

    fun getText(): CharSequence? {
        return binding.tvNudeButtonLabel.text
    }
}
