package com.example.receipttracking.fragment

import android.content.Context
import android.content.Intent
import android.icu.text.NumberFormat
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import com.example.receipttracking.R
import com.example.receipttracking.activities.DetailsActivity.Companion.EDIT_RECEIPT
import com.example.receipttracking.model.ReceiptsMockData.Companion.receiptList
import kotlinx.android.synthetic.main.details_fragment.*
import com.example.receipttracking.activities.ListActivity
import com.example.receipttracking.model.ReceiptsMockData
import com.example.receipttracking.model.utils.Companion.fromDateLong
import java.util.*


private var detailsID = 0


class DetailsFragment : Fragment() {
    private var listener: OnDetailsFragmentListener? = null

    /*
    *  functions:
    * populate(id)
    * populates the fields based on the id provided
    * exists as an object itself in order to allow previous/next functionality
    * */

    fun populate(id: Int) {

        //get the receipt object at the list id
        var currentReceipt = receiptList[id]

        tv_merchant_name.text = currentReceipt.merchantName
        tv_category.text = currentReceipt.category
        //TODO:proper formatting for date and money, should be able to grab a freeware class for both thrings -- or may be handled inkotlin alreayd
        // either way come back to this
        tv_date.text = fromDateLong(currentReceipt.date)
        tv_amount.text = currentReceipt.cost.toString()
        tv_mock_id.text = currentReceipt.mockID.toString()

        //if it's a mock receipt/no image specified set as appropriate resource file, otherwise set as uri
        if (currentReceipt.receiptImage != 0) {
            iv_receipt_image.setImageResource(currentReceipt.receiptImage)
        } else {
            iv_receipt_image.setImageURI(currentReceipt.receiptImageURI.toUri())
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            detailsID = arguments?.getInt(EDIT_RECEIPT) ?: 0
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onDetailsFragmentInteraction(uri)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        populate(detailsID)

        btn_previous.setOnClickListener {
            if (detailsID >= 1) {
                detailsID--
            } else {
                detailsID = receiptList.size - 1
            }
            populate(detailsID)
        }
        btn_next.setOnClickListener {
            if (detailsID < receiptList.size - 1) {
                detailsID++
            } else {
                detailsID = 0
            }
            populate(detailsID)
        }

        btn_edit.setOnClickListener {
            val fragment = EditFragment.newInstance(detailsID, null)
            // val bundle = Bundle()
            //bundle.putInt(EDIT_RECEIPT,id)
            //  fragment.setArguments(bundle)
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(com.example.receipttracking.R.id.fragment_holder, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }



        btn_return.setOnClickListener {
            val intent = Intent(view.context, ListActivity::class.java)
            startActivity(intent)
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDetailsFragmentListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnDetailsFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnDetailsFragmentListener {
        // TODO: Update argument type and name
        fun onDetailsFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(EDIT_RECEIPT, param1)
                }
            }
    }
}
