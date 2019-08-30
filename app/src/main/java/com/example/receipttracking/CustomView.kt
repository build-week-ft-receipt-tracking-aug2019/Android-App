package com.example.receipttracking

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout

//Adds Image to ReccylerView
class CustomView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {


    init {
        val image = ImageView(context)
        image.setImageResource(R.drawable.ic_receipt_green_24dp)
        addView(image)

    }

}



