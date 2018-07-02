package com.coordinate.behavier.behavier

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View

class ScrollBehavier(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs){
    val TAG  = "ScrollBehavier"
    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        val bVertical = (axes and ViewCompat.SCROLL_AXIS_VERTICAL) != 0
        Log.i(TAG, "onStartNestedScroll child = $child target = $target axes = $axes type = $type bVertical = $bVertical")


        return bVertical
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        Log.i(TAG, "onNestedPreScroll  dx = $dx dy = $dy child y = ${child.y} height = ${child.height}")
        if(child.y < -child.height)
        {
            consumed[1] = 0
        }else if(child.y > child.height){
            consumed[1] = 0

        }else
        {
            consumed[1] = 0

            if(dy > 0)
            {
                if(child.y - dy >= -child.height)
                {
                    //向上滑动
                    consumed[1] = dy
                    child.y -= dy.toFloat()
                }else
                {
                    consumed[1] = child.height + child.y.toInt()
                    child.y = -child.height.toFloat()
                }
            }else
            {
                if(child.y - dy <= 0)
                {
                    consumed[1] = dy
                    child.y -= dy.toFloat()
                }else
                {
                    consumed[1] =  child.y.toInt()
                    child.y = 0.0f
                }
            }
        }
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }
}