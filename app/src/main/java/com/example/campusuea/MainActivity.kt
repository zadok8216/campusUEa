package com.example.campusuea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.est_text).setOnClickListener { openUniversityFrame() }
    }

    fun openUniversityFrame(){
       //Bloco de codigo//
    }
}