package com.test.moviedb.presentatiion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.moviedb.core.domain.MovieDbItemDetail
import com.test.moviedb.core.domain.Response
import com.test.moviedb.core.interactors.MovieDBDetailInteractors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val movieDBDetailInteractors: MovieDBDetailInteractors):ViewModel() {

    private val _detail = MutableLiveData<Response<MovieDbItemDetail>>(Response.UnInitialized)
    val detail : LiveData<Response<MovieDbItemDetail>> get() = _detail

    fun loadDetail(movieId:Int, isMovie:Boolean){
        if (isMovie)
            viewModelScope.launch(Dispatchers.IO)  {
                _detail.postValue(movieDBDetailInteractors.getMovieDetailUseCase.invoke(movieId))
            }
        else
            viewModelScope.launch(Dispatchers.IO)  {
                _detail.postValue(movieDBDetailInteractors.getTvShowsDetailUseCase.invoke(movieId))
            }
    }
}