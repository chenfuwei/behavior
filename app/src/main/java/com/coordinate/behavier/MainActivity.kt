package com.coordinate.behavier

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coordinate.behavier.databinding.ActivityMainBinding
import com.coordinate.behavier.databinding.ItemTestBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var fragments : MutableList<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initFragments()
        binding.viewpage.adapter = object : FragmentPagerAdapter(getSupportFragmentManager()){
            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }

            override fun getCount(): Int {
                return fragments.size
            }
        }
        binding.navigatoinView.setOnNavigationItemSelectedListener {  true }
    }

    fun initFragments()
    {
        fragments = ArrayList()
        fragments.add(TestFragment.newInstance())
        fragments.add(TestFragment.newInstance())
        fragments.add(TestFragment.newInstance())
        fragments.add(TestFragment.newInstance())
    }
}
