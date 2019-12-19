package com.example.promoviejet.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.promoviejet.data.MovieRepository
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.ui.utils.FakeDataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class FavoriteViewModelTest {

    @Rule
    @JvmField val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var movieRepository: MovieRepository

    lateinit var favoriteViewModel: FavoriteViewModel

    @Mock
    lateinit var observerTvShow: Observer<PagedList<TvShow>>

    @Mock
    lateinit var observerMovie: Observer<PagedList<Movie>>

    @Mock
    lateinit var pagedListMovie : PagedList<Movie>

    @Mock
    lateinit var pagedListTvShow : PagedList<TvShow>

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        favoriteViewModel = FavoriteViewModel(movieRepository)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyFavoriteMovie = MutableLiveData<PagedList<Movie>>()
        dummyFavoriteMovie.value = pagedListMovie

        Mockito.`when`(movieRepository.getFavoritesMovie()).thenReturn(dummyFavoriteMovie)

        favoriteViewModel.getFavoriteMovie().observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(pagedListMovie)

    }

    @Test
    fun getFavoriteTvShow() {
        val dummyFavoriteTvShow = MutableLiveData<PagedList<TvShow>>()
        dummyFavoriteTvShow.value = pagedListTvShow

        Mockito.`when`(movieRepository.getFavoritesTvShow()).thenReturn(dummyFavoriteTvShow)

        favoriteViewModel.getFavoriteTvShow().observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(pagedListTvShow)

    }
}