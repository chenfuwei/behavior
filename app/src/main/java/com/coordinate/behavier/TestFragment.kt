package com.coordinate.behavier

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coordinate.behavier.databinding.FragmentTestBinding
import com.coordinate.behavier.databinding.ItemTestBinding

class TestFragment : Fragment(){
    lateinit var binding:FragmentTestBinding
    lateinit var data : MutableList<String>
    lateinit var adapter: TestAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTestBinding.inflate(inflater)
        initData()
        return binding.root
    }

    fun initData()
    {
        data = ArrayList<String>()
        for(i in 0..99)
        {
            data.add("$i test")
        }
        adapter = TestAdapter()
        binding.recycle.layoutManager = LinearLayoutManager(context)
        binding.recycle.adapter = adapter

    }

    companion object {
        fun newInstance() : Fragment
        {
            val fragment = TestFragment()
            return fragment
        }
    }

    inner class TestViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        fun initValue(position: Int)
        {
            val itemBinding: ItemTestBinding? =  DataBindingUtil.bind(itemView)
            itemBinding?.testTv?.text = data[position]
        }
    }

     inner class TestAdapter : RecyclerView.Adapter<TestViewHolder>()
    {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_test, null)
            return TestViewHolder(view)
        }

        override fun getItemCount(): Int {
           return data.size
        }

        override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
            holder.initValue(position)
        }
    }
}