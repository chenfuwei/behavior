package com.coordinate.behavier.behavier

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button

class TestBehavier(context: Context?, attrs: AttributeSet?) : CoordinatorLayout.Behavior<View>(context, attrs){
    val TAG  = "TestBehavier"

    override fun layoutDependsOn(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        Log.i(TAG, "layoutDependsOnview = $child dependency = $dependency")

        return dependency is Button
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        Log.i(TAG, "onDependentViewChanged dependency = $dependency x = ${dependency?.x} y = ${dependency?.y}")
        child?.x = dependency!!.x + 200
        child?.y = dependency!!.y + 200
        return super.onDependentViewChanged(parent, child, dependency)
    }
}