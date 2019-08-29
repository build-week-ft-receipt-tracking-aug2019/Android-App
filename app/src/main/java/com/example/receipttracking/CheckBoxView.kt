package com.example.receipttracking

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.checkbox_view.view.*

class CheckBoxView (context: Context, attrs: AttributeSet): LinearLayout(context, attrs){

    companion object{
        var isChecked = false
    }

    private var cardID: Int = 0

    fun setChecked(checked: Boolean){

        isChecked = checked
        setInitial(isChecked)

    }

    init {
        View.inflate(context, R.layout.checkbox_view, this)
        var myImage = findViewById(R.id.customView_checkbox)
    }



    fun setInitial(pos: Boolean){
        val checked = ContextCompat.getDrawable(context, R.drawable.ic_check_box_black_24dp)
        val notChecked = ContextCompat.getDrawable(context, R.drawable.ic_check_box_outline_blank_black_24dp)

        when(pos){

            true -> imageView_check.setImageDrawable(checked)
            false -> imageView_check.setImageDrawable(notChecked)


        }



    }

}