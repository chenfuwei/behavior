package com.coordinate.behavier

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.coordinate.behavier.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    lateinit var binding : ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first)
        binding.simpleBehavior.setOnClickListener { startActivity(Intent(this@FirstActivity, SimpleActivity::class.java)) }

        binding.scrollBehavior.setOnClickListener {
            startActivity(Intent(this@FirstActivity, MainActivity::class.java))
        }
    }
}
