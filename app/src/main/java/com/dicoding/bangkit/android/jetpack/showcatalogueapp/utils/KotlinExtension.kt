package com.dicoding.bangkit.android.jetpack.showcatalogueapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.R

fun ImageView.loadFromUrl(path: String) {
    Glide.with(this).clear(this)
    Glide.with(this)
        .setDefaultRequestOptions(RequestOptions()
            .placeholder(R.drawable.ic_favorite_true)
            .error(R.drawable.default_icon)
    ).load(path).into(this)
}