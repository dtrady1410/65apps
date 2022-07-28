package com.example.project1

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.project1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var calHeight : TextView? = null
    var calWeight : TextView? = null
    var calAge : TextView? = null
    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        bindingClass.checkBtn.setOnClickListener{
            calHeight = findViewById(R.id.calHeight)
            calWeight = findViewById(R.id.calWeight)
            calAge = findViewById(R.id.calAge)
            if((calHeight?.text.toString() != "") && (calWeight?.text.toString() != "") && (calAge?.text.toString() != "")){
                bindingClass.varHeight.text = getString(R.string.VarHeight) + " " + calHeight?.text.toString()
                bindingClass.varWeight.text = getString(R.string.VarWeight) + " " + calWeight?.text.toString()
                bindingClass.varAge.text = getString(R.string.VarAge) + " " + calAge?.text.toString()
                bindingClass.answerTxt.text = getString(R.string.AnswerSuc)
                bindingClass.answerTxt.setTextColor(resources.getColor(R.color.NormCol))
                bindingClass.answerTxt.visibility = View.VISIBLE
                bindingClass.checkBtn.visibility = View.GONE
                bindingClass.checkBtn2.visibility = View.VISIBLE


            }
            else{
                bindingClass.answerTxt.text = getString(R.string.AnswerError)
                bindingClass.answerTxt.setTextColor(Color.RED)
                bindingClass.answerTxt.visibility = View.VISIBLE
            }

        }

        bindingClass.checkBtn2.setOnClickListener{
            val i = Intent(this, MainActivity2::class.java)
            val Str : String = "Формула: (9,99 * ${calWeight?.text.toString()} + 6,25 * " +
                    "${calHeight?.text.toString()} - 4,92 * ${calAge?.text.toString()} + 5) * 1,2"
            val Reuslt = (9.99 * calWeight?.text.toString().toInt() + 6.25 *
                    calHeight?.text.toString().toInt() - 4.92 *
                    calAge?.text.toString().toInt() + 5) * 1.2
            i.putExtra("key1", Str)
            i.putExtra("key2", Reuslt.toInt().toString())
            startActivityForResult(i, 100)
       }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

}

