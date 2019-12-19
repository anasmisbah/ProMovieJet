package com.example.promoviejet.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.promoviejet.R
import com.example.promoviejet.ui.home.HomeActivity
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
        delay(3000)
    }
}
