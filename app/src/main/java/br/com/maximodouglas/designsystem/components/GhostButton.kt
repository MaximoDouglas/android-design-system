package br.com.maximodouglas.designsystem.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.getColor
import androidx.databinding.DataBindingUtil
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.GhostButtonBinding

class GhostButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var bindind: GhostButtonBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.ghost_button,
            this,
            true
        )

    override fun setEnabled(isEnabled: Boolean) {
        super.setEnabled(isEnabled)

        with(bindind) {
            tvGhostButtonLabel.setTextColor(
                getColor(context, R.color.md_green50.takeIf { isEnabled } ?: R.color.md_black40)
            )

            llGhostButtonContainer.setBackgroundResource(
                R.drawable.ghost_button_background_selector.takeIf { isEnabled }
                    ?: R.drawable.shape_rectangle_black40_corner_8
            )
        }
    }

    fun setText(text: String) {
        bindind.tvGhostButtonLabel.text = text
    }

    fun getText(): CharSequence? {
        return bindind.tvGhostButtonLabel.text
    }
}
