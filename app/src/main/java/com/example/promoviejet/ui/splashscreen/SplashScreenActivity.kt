package com.example.promoviejet.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.promoviejet.R
import com.example.promoviejet.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val anim = AnimationUtils.loadAnimation(this@SplashScreenActivity,R.anim.fromtop)
        logo_splashscreen.animation = anim
        CoroutineScope(IO).launch {
            addDelaySplashScreen()
            goToHome()
        }
    }


    private suspend fun goToHome(){
        withContext(Main){
            startActivity(Intent(this@SplashScreenActivity,HomeActivity::class.java))
        }
    }

    private suspend fun addDelaySplashScreen(){
        delay(2000)
    }
}
