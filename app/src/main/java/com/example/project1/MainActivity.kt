package com.example.project1

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.project1.constance.Constance
import com.example.project1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.checkBtn.setOnClickListener{
            val heightVal = bindingClass.calValue.text.toString().toInt()
            when(heightVal){
                in Constance.Height_1..300 -> {
                    bindingClass.ResultTxt.visibility = View.VISIBLE
                    bindingClass.ResultTxt.setTextColor(Color.parseColor("#1FA324"))
                    bindingClass.ResultTxt.text = "Успешно"
                    bindingClass.varHeight.text = "Ваш рост: $heightVal"
                }
                else -> {
                    bindingClass.ResultTxt.visibility = View.VISIBLE
                    bindingClass.ResultTxt.setTextColor(Color.RED)
                    bindingClass.ResultTxt.text = "Что-то пошло не так"
                }
            }
        }
    }

}