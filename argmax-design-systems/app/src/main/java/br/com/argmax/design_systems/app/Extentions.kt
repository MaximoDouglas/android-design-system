package br.com.argmax.design_systems.app

import android.widget.ImageView
import androidx.core.content.ContextCompat
import br.com.argmax.design_systems.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

fun ImageView.setCircularImageByUrlWithBorder(imageUrl: String, borderWidth: Int = 3) {
    this.background = ContextCompat.getDrawable(context, R.drawable.asphalt_white_oval_shape)
    this.setPadding(borderWidth, borderWidth, borderWidth, borderWidth)

    Glide.with(this)
        .load(imageUrl)
        .transform(CircleCrop())
        .into(this)
}