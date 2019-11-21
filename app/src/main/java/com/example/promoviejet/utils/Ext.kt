package com.example.promoviejet.utils

import android.content.Context
import android.view.View
import android.widget.Toast

fun View.visible(){
    this.visibility = View.VISIBLE
}
fun View.invisible(){
    this.visibility = View.GONE
}

fun Context.toast(msg : String){
    Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
}