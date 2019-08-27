package com.example.receipttracking.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.receipttracking.R

class DetailsActivity : AppCompatActivity() {

    companion object{
        const val KEY_RECEIPT = "RECEIPT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}
