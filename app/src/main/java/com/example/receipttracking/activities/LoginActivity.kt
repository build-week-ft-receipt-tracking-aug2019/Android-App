package com.example.receipttracking.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.Window
import android.animation.Animator
import android.content.Intent
import android.view.View.VISIBLE
import android.view.WindowManager
import com.example.receipttracking.R
import com.example.receipttracking.model.ReceiptsMockData.Companion.fillList
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        /*
        *
        *
        *
        * create mock data:
        *
        *
        *
        * */

        fillList()




        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_login)

        object : CountDownTimer(2000, 1000){
            override fun onFinish() {
                progress_bar_loading.visibility = View.GONE
                imageView_receipt_icon.setImageResource(R.drawable.receipt_tracker_logo)
                StartAnimation()
            }

            override fun onTick(p0: Long) {}

        }.start()


        button_login.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

        textView_skip.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }



    private fun StartAnimation(){
        imageView_receipt_icon.animate().apply {
            x(50f)
            y(100f)
            duration = 1000

        }.setListener(object : Animator.AnimatorListener {
            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {

            }

            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                animationView_after.visibility = VISIBLE
            }






        }






        )


    }
}
