package com.example.receipttracking

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout

class CheckBoxView (context: Context, attributeSet: AttributeSet): LinearLayout(context, attributeSet){

    /*
  *
  * view allows for automatic click handling
  * which sends a booleon value to the list of receipts on user interaction
  * and programatically the visual representation of this value
  *
  * */

    companion object {
        private var checkInternal = false
        private var position = 0
    }
    fun setRating(fav:Boolean) {
        if (fav){
            checkInternal =true
        }
    }
    fun setPosition(pos:Int) {
        position=pos
    }

    init {
        inflate(context,R.layout.alt_check_box, this)
        val image:ImageView = findViewById(R.id.check)
        val checked= R.drawable.ic_check_box_black_24dp
        val unchecked = R.drawable.ic_check_box_outline_blank_black_24dp
            image.setImageResource(unchecked)
        setOnClickListener{
            if (checkInternal==false) {
                checkInternal=true
                image.setImageResource(checked)
          //      receiptList[position].favorite=true
            }
            else {
                checkInternal=false
                image.setImageResource(unchecked)
         //       receiptList[position].favorite=false
            }
        }
    }

}
