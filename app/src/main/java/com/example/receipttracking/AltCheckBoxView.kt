package com.example.receipttracking

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.receipttracking.model.DataRepository.Companion.receiptList

class AltCheckBoxView (context: Context, attributeSet: AttributeSet): LinearLayout(context, attributeSet){


    /*
    *
    * view allows for automatic click handling
    * which sends a booleon value to the list of receipts on user interaction
    * and programatically the visual representation of this value
    *
    * */

    companion object {

        private var position = 0
    }

    fun setPosition(pos:Int) {
        position=pos
    }

    init {

        inflate(context,R.layout.alt_check_box, this)
        val image:ImageView = findViewById(R.id.check)
        val checked= R.drawable.ic_check_box_black_24dp
        val unchecked = R.drawable.ic_check_box_outline_blank_black_24dp
         //   image.setImageResource(unchecked)
        if(receiptList[position].favorite==false) {
            image.setImageResource(unchecked)
        }
        else {
            image.setImageResource(checked)
        }
        setOnClickListener{
            if (receiptList[position].favorite==false) {
                image.setImageResource(checked)
                receiptList[position].favorite=true
            }
            else {
                image.setImageResource(unchecked)
                receiptList[position].favorite=false
            }
        }


    }

}
