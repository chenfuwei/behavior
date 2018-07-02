package com.coordinate.behavier

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.coordinate.behavier.databinding.ActivitySimpleBinding


class SimpleActivity : AppCompatActivity() {
    lateinit var binding : ActivitySimpleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple)

        binding.testDependency.setOnTouchListener { v, event ->
            v.x = event.x
            v.y = event.y
            true
        }
    }
}
