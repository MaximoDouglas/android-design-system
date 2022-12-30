package com.maximodouglas.mdskit.utils

import android.content.Context
import android.util.DisplayMetrics.DENSITY_DEFAULT
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText

fun Context.convertPixelToDp(sizeInPixels: Int): Int {
    return (sizeInPixels * this.resources.displayMetrics.densityDpi) / DENSITY_DEFAULT
}

fun Context.showToast(string: String) {
    makeText(this, string, LENGTH_SHORT).show()
}
