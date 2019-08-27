package com.example.receipttracking.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.receipttracking.R
import com.example.receipttracking.model.ReceiptsMockData.Companion.list

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

    fileList()
        println(list)
    }
}
