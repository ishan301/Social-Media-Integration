package com.example.socialmediaintegration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class SplashScreen : AppCompatActivity() {

    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        auth= FirebaseAuth.getInstance()
        val user=auth.currentUser

        // If user is not authenticated send him to MainActivity(for signing in) else navigate him to dashboard
        Handler().postDelayed({
            if(user!=null)
            {
                val dashboardIntent=Intent(this,Dashboard::class.java)
                startActivity(dashboardIntent)
            }
            else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            finish()
        },3000) //delay time
    }
}