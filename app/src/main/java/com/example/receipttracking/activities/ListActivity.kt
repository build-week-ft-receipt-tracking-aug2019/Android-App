package com.example.receipttracking.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.receipttracking.R
import com.example.receipttracking.model.ReceiptsMockData.Companion.fillList
import com.example.receipttracking.model.ReceiptsMockData.Companion.receipt_list
import com.example.receipttracking.recyclerview.Adapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        //fills receipt_list and printlns as sanity check
       fillList()


        recycler_view.apply {

            /*val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            adapter=Adapter(list)
            recycle_view.layoutManager = manager
            recycle_view.adapter = adapter*/

            layoutManager = LinearLayoutManager(this@ListActivity, RecyclerView.VERTICAL, false)
            adapter = Adapter(receipt_list)
        }



    }
}
