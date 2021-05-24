package com.dicoding.bangkit.android.jetpack.showcatalogueapp.di.home

import com.dicoding.bangkit.android.jetpack.showcatalogueapp.di.home.favorite.FavoriteFragmentBuildersModule
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.mainhome.content.favorite.FavoriteFragment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.mainhome.content.movie.MovieFragment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.mainhome.content.tvshow.TvshowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMovieFragment() : MovieFragment

    @ContributesAndroidInjector
    abstract fun contributeTvShowFragment() : TvshowFragment

    @ContributesAndroidInjector(modules = [FavoriteFragmentBuildersModule::class])
    abstract fun contributeFavoriteFragment() : FavoriteFragment
}