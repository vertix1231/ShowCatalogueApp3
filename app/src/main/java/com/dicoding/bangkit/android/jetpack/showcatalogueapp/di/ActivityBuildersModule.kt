package com.dicoding.bangkit.android.jetpack.showcatalogueapp.di

import com.dicoding.bangkit.android.jetpack.showcatalogueapp.di.home.HomeFragmentBuildersModule
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.detail.DetailActivity
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.mainhome.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [HomeFragmentBuildersModule::class])
    abstract fun contributeHomeActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailActivity

}