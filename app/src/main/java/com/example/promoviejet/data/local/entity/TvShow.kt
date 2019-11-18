package com.example.promoviejet.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TvShow(
     @PrimaryKey(autoGenerate = false)
     @ColumnInfo(name = "id")
     val id:String,
     @ColumnInfo(name = "title")
     val title :String,
     @ColumnInfo(name = "voteAverage")
     val voteAverage :String,
     @ColumnInfo(name = "language")
     val language :String,
     @ColumnInfo(name = "overview")
     val overview :String,
     @ColumnInfo(name = "releaseDate")
     val releaseDate :String,
     @ColumnInfo(name = "poster")
     val poster :String,
     @ColumnInfo(name = "backDrop")
     val backDrop: String? = null
)