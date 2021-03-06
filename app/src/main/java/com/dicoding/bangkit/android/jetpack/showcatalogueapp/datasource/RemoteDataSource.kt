package com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.remote.api.ApiService
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.remote.response.MovieResponse
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.remote.response.TvShowResponse
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.remote.vo.ApiResponse
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.await
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val catalogApiService: ApiService) {

    fun getNowPlayingMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovieResponse = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        CoroutineScope(IO).launch {
            try {
                val response = catalogApiService.getNowPlayingMovies().await()
                resultMovieResponse.postValue(ApiResponse.success(response.result!!))
            } catch (e: IOException) {
                e.printStackTrace()
                resultMovieResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultMovieResponse
    }

    fun getTvShowOnTheAir(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShowResponse = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        CoroutineScope(IO).launch {
            try {
                val response = catalogApiService.getTvShowOnTheAir().await()
                resultTvShowResponse.postValue(ApiResponse.success(response.result!!))
            } catch (e: IOException) {
                e.printStackTrace()
                resultTvShowResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultTvShowResponse
    }

}