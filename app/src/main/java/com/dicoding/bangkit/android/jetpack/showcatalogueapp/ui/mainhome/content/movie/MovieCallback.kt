package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.mainhome.content.movie

import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.local.entity.MovieEntity

interface MovieCallback {
    fun onItemClicked(data: MovieEntity)
}