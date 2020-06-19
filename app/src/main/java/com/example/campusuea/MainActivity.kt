package com.example.campusuea

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var name : String
    private var latcher = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        done_button.setOnClickListener { buttonClickHandlle(it) }
        text_nome.setOnClickListener { changeName() }
        retriveData()
        if(latcher){
            setVisibility()
        }

    }

    private fun changeName(){
        text_nome.visibility = View.GONE
        editView.visibility = View.VISIBLE
        done_button.visibility = View.VISIBLE

    }

    private fun buttonClickHandlle(view: View){


        val stringPlusNome = editView.text.toString()

        text_nome.text = stringPlusNome
        name = text_nome.text.toString()
        latcher = true

        editView.visibility = View.GONE
        done_button.visibility = View.GONE
        text_nome.visibility = View.VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

        val preferences = getSharedPreferences("MyPreference", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        editor.putString("name",text_nome.text.toString())
        editor.putBoolean("latche",latcher)
        editor.apply()

    }

    fun retriveData(){
        val preferences = getSharedPreferences("MyPreference", Context.MODE_PRIVATE)

        name = preferences.getString("name","").toString()
        latcher = preferences.getBoolean("latche",false)

    }

    fun setVisibility(){

        text_nome.text = name

        editView.visibility = View.GONE
        done_button.visibility = View.GONE
        text_nome.visibility = View.VISIBLE
    }

}