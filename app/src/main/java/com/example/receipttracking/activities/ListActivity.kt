package com.example.receipttracking.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.receipttracking.R
import com.example.receipttracking.model.Receipts
import com.example.receipttracking.model.ReceiptsMockData
import com.example.receipttracking.model.ReceiptsMockData.Companion.fillList
import com.example.receipttracking.model.ReceiptsMockData.Companion.receipt_list
import com.example.receipttracking.recyclerview.Adapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        //fills receipt_list and printlns as sanity check
       /*fillList()
        println(receipt_list)*/

        recycler_view_holder.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = Adapter(receipt_list)
        }



    }
}
