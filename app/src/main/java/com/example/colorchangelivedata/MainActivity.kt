package com.example.colorchangelivedata

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val colorChangerViewModel = ViewModelProviders.of(this).get(ColorChangerViewModel::class.java)
        colorChangerViewModel.colorResource.observe(this, object:Observer<Int>{
            override fun onChanged(t: Int?) {
                root_view.setBackgroundColor(t!!)
            }

        })

        color_btn.setOnClickListener {
            colorChangerViewModel.colorResource.value = generateColor()
        }

        btn_next.setOnClickListener {
            intent = Intent(this@MainActivity,TImerColorChanger::class.java)
            startActivity(intent)
        }

        btn_user.setOnClickListener {
            intent = Intent(this@MainActivity,UserActivity::class.java)
            startActivity(intent)
        }


    }

    private fun generateColor() : Int {
        val ran = Random
        return  Color.argb(255,ran.nextInt(256),ran.nextInt(256),ran.nextInt(256))
    }
}
