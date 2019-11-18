package com.example.promoviejet.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.data.MovieRepository
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.remote.RemoteRepository
import com.example.promoviejet.ui.utils.FakeDataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class MovieViewModelTest{


    @Rule @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    lateinit var movieRepository: MovieRepository

    lateinit var movieViewModel: MovieViewModel



    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        movieViewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovies(){
        val dummyMovies = FakeDataDummy.generateDummyMovie()


        val movies = MutableLiveData<List<Movie>>()
        movies.value = dummyMovies

        `when`(movieRepository.getMovie(BuildConfig.API_KEY)).thenReturn(movies)

        var observer = mock(Observer::class.java) as Observer<List<Movie>>


        movieViewModel.getMovies().observeForever(observer)

        verify(observer).onChanged(dummyMovies)
    }
}