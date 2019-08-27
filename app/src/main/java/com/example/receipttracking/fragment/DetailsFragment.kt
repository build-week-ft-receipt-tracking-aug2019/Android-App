package com.example.receipttracking.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.receipttracking.R
import com.example.receipttracking.model.ReceiptsMockData.Companion.receiptList
import kotlinx.android.synthetic.main.details_fragment.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class DetailsFragment : Fragment() {
    /*
    *  functions:
    * populate(id)
    * populates the fields based on the id provided
    *
    *
    *
    *
    *
    * */

fun populate(id:Int) {

    val id = arguments?.getInt(ITEM_KEY) ?: "Not a congressman"
    Log.i("lognow", "id = $id")
    //get the receipt object at the list id
    var currentReceipt = receiptList[id]


    ev_merchant_name
    ev_category
    ev_date
    ev_amount
    tv_mock_id
    iv_receipt_image
/*
    val singleMemberDetails: CongresspersonDetails? = CongressDao.getMemberDetails(id)

    if (singleMemberDetails != null) {

        //twittercheck
        var tweet = "${singleMemberDetails.firstName}  ${singleMemberDetails.lastName}"
        if (singleMemberDetails.twitterAccount != null && singleMemberDetails.twitterAccount != "null") {
            tweet += "\nTwitter account: ${singleMemberDetails.twitterAccount}"
        }
        tv_first_name.text = tweet


        iv_drawable.setImageBitmap(CongressDao.getImage(id))*/
    }
}







    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnDetailsFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onDetailsFragmentInteraction(uri)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
btn_edit.setOnClickListener {
    println("hello hello, hello everyone, this is popular music")
}
        /*btn_edit
btn_return
btn_previous
btn_next*/
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
