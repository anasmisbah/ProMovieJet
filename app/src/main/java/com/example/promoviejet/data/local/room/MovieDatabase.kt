package com.example.promoviejet.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.MovieTemp
import com.example.promoviejet.data.local.entity.TvShow


@Database(entities = [Movie::class,TvShow::class,MovieTemp::class],version = 2,exportSchema = false)
abstract class MovieDatabase : RoomDatabase(){

    abstract fun movieDao() : MovieDao

    companion object{
        private var INSTANCE : MovieDatabase? = null

        fun getInstance(context:Context): MovieDatabase{
            synchronized(MovieDatabase::class.java){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,MovieDatabase::class.java,"movie.db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE as MovieDatabase
        }
    }

}