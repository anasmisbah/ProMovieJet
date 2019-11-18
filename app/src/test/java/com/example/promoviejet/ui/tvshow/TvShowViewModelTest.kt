package com.example.promoviejet.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.data.MovieRepository
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.data.remote.RemoteRepository
import com.example.promoviejet.ui.utils.FakeDataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TvShowViewModelTest{

    @Rule @JvmField val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var movieRepository: MovieRepository

    lateinit var tvShowViewModel: TvShowViewModel

    @Mock
    lateinit var observer: Observer<List<TvShow>>

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        tvShowViewModel = TvShowViewModel(movieRepository)
    }

    @Test
    fun getTvShows(){
        val dummyTvShows = FakeDataDummy.generateDummyTvShow()

        val tvShows = MutableLiveData<List<TvShow>>()
        tvShows.value = dummyTvShows

        Mockito.`when`(movieRepository.getTvShow(BuildConfig.API_KEY)).thenReturn(tvShows)



        tvShowViewModel.getTvShow().observeForever(observer)

        Mockito.verify(observer).onChanged(dummyTvShows)
    }
}