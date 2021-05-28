package com.example.myapplication

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.myapplication.databinding.ActivitySplashScreenBinding
import com.example.myapplication.view.activities.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashBinding: ActivitySplashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)


        //Getting rid of ui system
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){ // apabila versi sdk di hp yang di installi aplikasi lebih besar dari sourcode aplikasinya
            window.insetsController?.hide(WindowInsets.Type.statusBars()) // maka akan menyembunyikan systemUI // notifications bar
        } else {
            @Suppress("DEPRECATION") // apabila sdk versi HP klien lebih kecil dari source code kita maka kita gunakan cara suppress
            window.setFlags( // this piece of codes is very useful for older version phone
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN

            )
        }


        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_anim)

        splashBinding.tvSplash.animation = splashAnimation
        splashAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                //
            }

            override fun onAnimationEnd(animation: Animation?) {
               Handler(Looper.getMainLooper()).postDelayed({
                   startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                   finish()
               }, 1000)
            }

            override fun onAnimationRepeat(animation: Animation?) {
                TODO("Not yet implemented")
            }

        })

    }
}