package com.shashank.cu_placement_cell.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.shashank.cu_placement_cell.R
import android.view.animation.ScaleAnimation
import kotlinx.android.synthetic.main.activity_splash_screen.*

import android.view.View

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.shashank.cu_placement_cell.MainActivity


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
         supportActionBar?.hide()
        zoom(cuLogo)
        var handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },1700)



    }
    fun zoom(view: View?) {

        val animation1: Animation = AnimationUtils.loadAnimation(applicationContext,
           R.anim.zoom_animation)
     view?.startAnimation(animation1)
    }

}