package br.com.argmax.design_systems.app

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setCircularImageByUrl(imageUrl: String) {
    Glide.with(context)
        .load(imageUrl)
        .centerCrop()
        .into(this)
}