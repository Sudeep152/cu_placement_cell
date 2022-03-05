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
import com.google.firebase.auth.FirebaseAuth
import com.shashank.cu_placement_cell.MainActivity
import com.shashank.cu_placement_cell.ui.home.HomeActivity


class SplashScreenActivity : AppCompatActivity() {
    lateinit var  mAuth :FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        mAuth= FirebaseAuth.getInstance()
         supportActionBar?.hide()
        zoom(cuLogo)
        var handler = Handler()
        handler.postDelayed({
            if(mAuth.currentUser !=null){
                startActivity(Intent(this,HomeActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }


        },1800)



    }
    fun zoom(view: View?) {

        val animation1: Animation = AnimationUtils.loadAnimation(applicationContext,
           R.anim.zoom_animation)
     view?.startAnimation(animation1)
    }

}