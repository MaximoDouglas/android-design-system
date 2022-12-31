package com.maximodouglas.mdskit.utils

import android.content.Context
import android.util.DisplayMetrics.DENSITY_DEFAULT
import android.view.View
import android.widget.ImageView
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.maximodouglas.mdskit.R

fun Context.convertPixelToDp(sizeInPixels: Int): Int {
    return (sizeInPixels * this.resources.displayMetrics.densityDpi) / DENSITY_DEFAULT
}

fun Context.showToast(string: String) {
    makeText(this, string, LENGTH_SHORT).show()
}

fun ImageView.setCircularImageByUrlWithBorder(imageUrl: String, borderWidth: Int = 3) {
    background = ContextCompat.getDrawable(context, R.drawable.shape_oval_white)
    setPadding(borderWidth, borderWidth, borderWidth, borderWidth)

    Glide.with(this)
        .load(imageUrl)
        .transform(CircleCrop())
        .into(this)

    visibility = View.GONE.takeIf { imageUrl.isEmpty() } ?: View.VISIBLE
}
