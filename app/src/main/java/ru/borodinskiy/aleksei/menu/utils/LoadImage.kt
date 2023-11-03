package ru.borodinskiy.aleksei.menu.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import ru.borodinskiy.aleksei.menu.R

fun ImageView.load(url: String, vararg transforms: BitmapTransformation = emptyArray()) =
    Glide.with(this)
        .load(url)
        .error(R.drawable.ic_cloche_24)
//        .timeout(10_000)
        .transform(*transforms)
        .into(this)