package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.mainhome

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.CatalogRepository
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.local.entity.MovieEntity
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.local.entity.TvShowEntity
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.vo.Resource
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val catalogRepository: CatalogRepository) :
    ViewModel() {

    fun getListNowPlayingMovies(): LiveData<Resource<PagedList<MovieEntity>>> = catalogRepository.getNowPlayingMovies()

    fun getListOnTheAirTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = catalogRepository.getTvShowOnTheAir()

}