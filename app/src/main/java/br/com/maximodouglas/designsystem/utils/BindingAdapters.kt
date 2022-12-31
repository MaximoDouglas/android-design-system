package br.com.maximodouglas.designsystem.utils

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleOrGone")
fun View.isVisibleOrGone(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}
