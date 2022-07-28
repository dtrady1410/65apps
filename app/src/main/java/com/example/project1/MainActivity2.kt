package com.example.project1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView
import com.example.project1.databinding.ActivityMain2Binding
import com.example.project1.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var bindingClass : ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.FormAct.text = intent.getStringExtra("key1")

        bindingClass.resultBtn.setOnClickListener(){
            bindingClass.FormAct.text =  intent.getStringExtra("key1") + " = " +
                    intent.getStringExtra("key2").toString() + " кл"
        }

        bindingClass.backBtn.setOnClickListener(){
            finish()
        }
    }
}
