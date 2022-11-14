package com.codehub.athtechapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        var button = findViewById<Button>(R.id.main_btn_blue)
        button.setOnClickListener {
            Log.d("App", "The user pressed the button!!!")
        }

//        button.setOnClickListener(object: View.OnClickListener {
//
//            override fun onClick(v: View?) {
//                Log.d("App", "The user pressed the button!!!")
//            }
//
//        })

        button.setOnLongClickListener {

//                Toast.makeText(MainActivity.this, "User pressed the button", Toast.LENGTH_LONG).show();
            Snackbar.make(it, "User pressed the button", 5000).show()
            return@setOnLongClickListener false
        }
    }

    override fun onPostResume() {
        super.onPostResume()

        var editText = findViewById<EditText>(R.id.main_edit_input)
        var edittextResult = editText.text.toString()
        editText.setText("Vassilis")
    }
}