package com.example.receipttracking.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import com.example.receipttracking.R
import com.example.receipttracking.activities.DetailsActivity.Companion.EDIT_RECEIPT
import com.example.receipttracking.model.DataRepository.Companion.receiptList
import kotlinx.android.synthetic.main.details_fragment.*
import com.example.receipttracking.activities.ListActivity
import com.example.receipttracking.model.utils.Companion.fromDateLong



/*
*
* displays most of the contents of a particular receipt
* and provides the user with the option to edit any particular receipt
*
*
* */






class DetailsFragment : Fragment() {
    private var listener: OnDetailsFragmentListener? = null
    private var detailsID = 0



    /*
    *
    * populate(id)
    * populates the fields based on the id provided
    * exists as an object itself in order to allow previous/next functionality
    * */

    fun populate(id: Int) {
                //  ^ id:Int is the actual position of the list being populated
                //  receiptlist ( at position) [id] . mockID
                // is the mock position
                // see notes in receiptsMockData

        //get the receipt object at the list id
        var currentReceipt = receiptList[id]

        tv_merchant_name.text = currentReceipt.merchantName
        tv_category.text = currentReceipt.category
        //TODO:proper formatting for date and money, should be able to grab a freeware class for both thrings -- or may be handled inkotlin alreayd
        // either way come back to this
        tv_date.text = fromDateLong(currentReceipt.date)
        tv_amount.text = currentReceipt.cost.toString()


        /*
        this following is the number you were asking about in messages last night
        the actual position in the list seems to get updated correctly
        the position is indicated in this part of the code by
        id, the Int value the method populate takes in
        */
        tv_mock_id.text ="" //currentReceipt.mockID.toString()

            //we'll take out the previous before we present tomorrow

        //if it's a mock receipt/no image specified set as appropriate resource file, otherwise set as uri
        if (currentReceipt.receiptImage != 0) {
            iv_receipt_image.setImageResource(currentReceipt.receiptImage)
        } else {
            iv_receipt_image.setImageURI(currentReceipt.receiptImageURI.toUri())
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // thos is where we get the position of the chosen receipt which will be gathered from .arguments
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

        // one the views are created, populate them with particular receipt lcoated at receiptList[detailsID]
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


        // the edit button opens a new EditFragment with the position in the list as detailsID
        btn_edit.setOnClickListener {
            val fragment = EditFragment.newInstance(detailsID, null)
            // val bundle = Bundle()
            //bundle.putInt(EDIT_RECEIPT,id)
            //  fragment.setArguments(bundle)
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fragment_holder, fragment)
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