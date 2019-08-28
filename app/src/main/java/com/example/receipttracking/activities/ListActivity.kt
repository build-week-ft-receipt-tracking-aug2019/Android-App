package com.example.receipttracking.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.receipttracking.R
import com.example.receipttracking.model.ReceiptsMockData.Companion.fillList


class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        println(receiptList)

       fillList()


        recycler_view.apply {

 
            layoutManager = LinearLayoutManager(this@ListActivity, RecyclerView.VERTICAL, false)
            adapter = Adapter(receipt_list)
        }



    }
}
