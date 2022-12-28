package br.com.maximodouglas.designsystem.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater.from
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil.inflate
import br.com.maximodouglas.designsystem.R
import br.com.maximodouglas.designsystem.databinding.AsphaltAlertBadgeBinding

class AlertBadge @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mBinding: AsphaltAlertBadgeBinding = inflate(
        from(context), R.layout.asphalt_alert_badge, this, true
    )

    fun setTitleText(text: String) {
        mBinding.tvAsphaltAlertBadgeTitle.text = text
    }

    fun getTitleText(): CharSequence? {
        return mBinding.tvAsphaltAlertBadgeTitle.text
    }

    fun setButtonText(text: String) {
        mBinding.tvAsphaltAlertBadgeNudeButton.text = text
    }

    fun getButtonText(): CharSequence? {
        return mBinding.tvAsphaltAlertBadgeNudeButton.text
    }

    override fun setOnClickListener(onClickListener: OnClickListener?) {
        onClickListener?.let {
            mBinding.tvAsphaltAlertBadgeNudeButton.setOnClickListener(onClickListener)
        }
    }

    override fun hasOnClickListeners(): Boolean {
        return mBinding.tvAsphaltAlertBadgeNudeButton.hasOnClickListeners()
    }
}