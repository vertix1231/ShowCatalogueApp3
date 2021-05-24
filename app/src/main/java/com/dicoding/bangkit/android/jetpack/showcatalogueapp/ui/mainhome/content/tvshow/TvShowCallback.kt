package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.mainhome.content.tvshow

import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.local.entity.TvShowEntity

interface TvShowCallback {
    fun onItemClicked(data: TvShowEntity)
}