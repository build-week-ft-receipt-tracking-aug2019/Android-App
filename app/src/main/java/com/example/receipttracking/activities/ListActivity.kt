package com.example.receipttracking.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.receipttracking.R
import com.example.receipttracking.activities.DetailsActivity.Companion.ADD_NEW_RECEIPT
import com.example.receipttracking.model.ReceiptsMockData.Companion.fillList
import com.example.receipttracking.model.ReceiptsMockData.Companion.receiptList
import com.example.receipttracking.recyclerview.Adapter
import kotlinx.android.synthetic.main.activity_list.*


class ListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)



        fillList()
        println(receiptList)
        recycler_view.apply {


            layoutManager = LinearLayoutManager(this@ListActivity, RecyclerView.VERTICAL, false)
            adapter = Adapter(receiptList)
        }
        button_add_new.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
           intent.putExtra(ADD_NEW_RECEIPT,1)


        }












    }
}
