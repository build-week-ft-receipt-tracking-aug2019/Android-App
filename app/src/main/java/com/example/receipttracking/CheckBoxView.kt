package com.example.receipttracking

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.checkbox_view.view.*
import java.util.jar.Attributes

class CheckBoxView(context: Context, attributeSet: AttributeSet): LinearLayout(context, attributeSet){

    init {
        val image = ImageView(context)
        image.setImageResource(R.drawable.ic_receipt_green_24dp)
        addView(image)
    }

}



