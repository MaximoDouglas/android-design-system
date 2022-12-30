package br.com.maximodouglas.designsystem.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.NudeButtonBinding

class NudeButton @JvmOverloads constructor(
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
            ContextCompat.getColor(context, R.color.md_red60.takeIf { isEnabled } ?: R.color.md_black40)
        )
    }

    fun setText(text: String) {
        binding.tvNudeButtonLabel.text = text
    }

    fun getText(): CharSequence? {
        return binding.tvNudeButtonLabel.text
    }
}
