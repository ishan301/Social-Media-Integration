package com.example.socialmediaintegration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        auth= FirebaseAuth.getInstance()
        val currentuser = auth.currentUser

        name.text=currentuser?.displayName
        email.text=currentuser?.email

        Glide.with(this).load(currentuser?.photoUrl.toString()).into(profile_image)

        sign_out_btn.setOnClickListener {
            auth.signOut()
            LoginManager.getInstance().logOut()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}