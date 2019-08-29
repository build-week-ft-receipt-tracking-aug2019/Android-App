package com.example.receipttracking

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.checkbox_view.view.*
import java.util.jar.Attributes

class CheckBoxView(context: Context, attributeSet: AttributeSet): LinearLayout(context, attributeSet){


    companion object{
        var isChecked = false


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        isChecked = true

        val checked = ContextCompat.getDrawable(context, R.drawable.ic_check_box_black_24dp)
        val notChecked = ContextCompat.getDrawable(context, R.drawable.ic_check_box_outline_blank_black_24dp)

        when(isChecked){

            true -> imageView_check.setImageDrawable(checked)
            false -> imageView_check.setImageDrawable(notChecked)


        }

        return false
    }



}


