package com.dicoding.bangkit.android.jetpack.showcatalogueapp.di.home.favorite

import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.mainhome.content.favorite.favoritemovie.FavoriteMovieFragment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.mainhome.content.favorite.favoritetvshow.FavoriteTvshowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoriteFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeFavoriteMovieFragment() : FavoriteMovieFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoriteTvShowFragment() : FavoriteTvshowFragment
}