package com.example.receipttracking.recyclerview


import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import com.example.receipttracking.R
import com.example.receipttracking.model.Receipts
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.receipttracking.activities.DetailsActivity
import kotlinx.android.synthetic.main.activity_items_list.view.*
import java.util.*


class Adapter(val receiptList: MutableList<Receipts>) : RecyclerView.Adapter<Adapter.viewHolder>() {

    private var data: List<Receipts> = ArrayList()


    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card: CardView = view.card_view
        val textViewName: TextView = view.tv_merchant_name
        val textViewAmount: TextView = view.tv_amount
        val textViewDate: TextView = view.tv_date


        fun bindModel(receipt: Receipts) {
            textViewName.text = receipt.merchantName
            textViewAmount.text = receipt.cost.toString()
            textViewDate.text = receipt.date.toString()


        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_list, parent, false) as View
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(viewHolder: viewHolder, position: Int) {
        val receipt = receiptList[position]
        viewHolder.bindModel(receipt)

        viewHolder.card.setOnClickListener { view ->

            val intent = Intent(view.context, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.KEY_RECEIPT, receipt)

            val optionsBundle: Bundle = ActivityOptions.makeSceneTransitionAnimation(
                view.context as Activity, viewHolder.textViewName,
                "tv_merchant_name"
            ).toBundle()
            view.context.startActivity(intent, optionsBundle)


        }

    }

}


