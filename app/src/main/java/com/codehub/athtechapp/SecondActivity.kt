package com.codehub.athtechapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val parameters: Bundle? = intent.extras
        if (parameters != null) {
            val name = parameters.getString("dev")
            val age = parameters.getInt("age")
        }

        findViewById<Button>(R.id.second_btn).setOnClickListener {
//            val intent = Intent(this, KotlinActivity::class.java)
//            startActivity(intent)
            onBackPressed()
//            finish()
        }
    }
}