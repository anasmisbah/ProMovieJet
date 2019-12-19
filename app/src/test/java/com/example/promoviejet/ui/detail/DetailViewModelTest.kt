package com.example.promoviejet.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.R
import com.example.promoviejet.data.MovieRepository
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.data.remote.RemoteRepository
import com.example.promoviejet.ui.utils.FakeDataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class DetailViewModelTest {

    @Rule @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var detailViewModel: DetailViewModel
     val dummyMovie: Movie = FakeDataDummy.generateDummyMovie()[0]
     val dummyTvShow: TvShow = FakeDataDummy.generateDummyTvShow()[0]


    @Mock
    lateinit var observerTvShow: Observer<TvShow>

    @Mock
    lateinit var movieRepository: MovieRepository

    @Mock
    lateinit var observerMovie: Observer<Movie>

    @Before
    fun  setUp(){
        MockitoAnnotations.initMocks(this)
        detailViewModel = DetailViewModel(movieRepository)
    }

    @Test
    fun getMovie(){
        val movie = MutableLiveData<Movie>()
        movie.value = dummyMovie

        `when`(movieRepository.getDetailMovie(dummyMovie.id,BuildConfig.API_KEY)).thenReturn(movie)

        detailViewModel.getMovie(dummyMovie.id).observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)



    }
    @Test
    fun getTvShow(){
        val tvShow = MutableLiveData<TvShow>()
        tvShow.value = dummyTvShow

        `when`(movieRepository.getDetailTvShow(dummyTvShow.id,BuildConfig.API_KEY)).thenReturn(tvShow)

        detailViewModel.getTvShow(dummyTvShow.id).observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)

    }

    @Test
    fun checkMovieFavorite(){
        `when`(movieRepository.checkFavoriteMovie(dummyMovie.id.toInt())).thenReturn(dummyMovie)
        val expect = dummyMovie !=null
        val result = detailViewModel.checkMovieFavorite(dummyMovie.id)
        assertEquals(expect,result)
    }

    @Test
    fun addMovieFavorite(){
        `when`(movieRepository.addFavoriteMovie(dummyMovie)).thenReturn(true)
        val result = detailViewModel.addMovieFavorite(dummyMovie)
        assertEquals(true,result)
    }
    @Test
    fun removeMovieFavorite(){
        `when`(movieRepository.removeFavoriteMovie(dummyMovie)).thenReturn(true)
        val result = detailViewModel.removeMovieFavorite(dummyMovie)
        assertEquals(true,result)
    }

    @Test
    fun checkTvShowFavorite(){
        `when`(movieRepository.checkFavoriteTvShow(dummyTvShow.id.toInt())).thenReturn(dummyTvShow)
        val expect = dummyTvShow != null
        val result = detailViewModel.checkTvShowFavorite(dummyTvShow.id)
        assertEquals(expect,result)
    }
    @Test
    fun addTvShowFavorite(){
        `when`(movieRepository.addFavoriteTvShow(dummyTvShow)).thenReturn(true)
        val result = detailViewModel.addTvShowFavorite(dummyTvShow)
        assertEquals(true,result)
    }
    @Test
    fun removeTvShowFavorite(){
        `when`(movieRepository.removeFavoriteTvShow(dummyTvShow)).thenReturn(true)
        val result = detailViewModel.removeTvShowFavorite(dummyTvShow)
        assertEquals(true,result)

    }
}