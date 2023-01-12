package com.ozancanguz.universities_turkey.ui.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ozancanguz.universities_turkey.R
import com.ozancanguz.universities_turkey.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(4000)
                    val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                    startActivity(intent)

                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}