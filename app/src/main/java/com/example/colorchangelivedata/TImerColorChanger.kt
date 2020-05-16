package com.example.colorchangelivedata

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_t_imer_color_changer.*
import java.util.*
import kotlin.random.Random

class TImerColorChanger : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_imer_color_changer)
        val timeChangerViewModel = ViewModelProviders.of(this).get(TimeChangerViewModel::class.java)
        val calendar = Calendar.getInstance()
        timeChangerViewModel.timeValue.observe(this, Observer{
            calendar.timeInMillis = it
            textTime.text = calendar.time.toString()
            timeChangerViewModel.colorResource.value = generateColor()

        })
        timeChangerViewModel.colorResource.observe(this, object:Observer<Int>{
            override fun onChanged(t: Int?) {
                root_time.setBackgroundColor(t!!)
            }

        })



    }

    private fun generateColor() : Int {
        val ran = Random
        return  Color.argb(255,ran.nextInt(256),ran.nextInt(256),ran.nextInt(256))
    }
}
