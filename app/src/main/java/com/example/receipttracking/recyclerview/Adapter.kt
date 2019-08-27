package com.example.receipttracking.recyclerview



import com.example.receipttracking.R
import com.example.receipttracking.model.Receipts
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class Adapter(/* TODO Add list */) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var data: List<Receipts> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_list, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    /*updates changes in RecyclerView*/

    fun swapData(data: List<Receipts>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Receipts) = with(itemView) {
            // TODO: Bind the data with View
            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}

