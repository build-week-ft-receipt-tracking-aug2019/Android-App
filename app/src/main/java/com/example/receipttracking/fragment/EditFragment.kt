package com.example.receipttracking.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import com.example.receipttracking.R
import com.example.receipttracking.activities.DetailsActivity.Companion.ADD_NEW_RECEIPT
import com.example.receipttracking.activities.DetailsActivity.Companion.EDIT_RECEIPT
import com.example.receipttracking.activities.DetailsActivity.Companion.READ_REQUEST_CODE
import com.example.receipttracking.model.Receipts
import com.example.receipttracking.model.ReceiptsMockData
import com.example.receipttracking.model.ReceiptsMockData.Companion.receiptList
import kotlinx.android.synthetic.main.details_fragment.iv_receipt_image
import kotlinx.android.synthetic.main.details_fragment.tv_mock_id
import kotlinx.android.synthetic.main.edit_fragment.*
import java.text.SimpleDateFormat
import java.util.*








class EditFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var id: Int? = null ?: -1
    private var newID: Int? = null ?: -1
    private var NEW_ITEM_FLAG = false
    private var listener: OnEditFragmentListener? = null
    private var uriS:String = ""
    fun fromDateLong(timeStampStr:Long):String{
        try {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = Date(timeStampStr * 1000)

            return sdf.format(netDate)
        } catch (ex: Exception) {
            return timeStampStr.toString()
        }
    }
fun toDateLong(input:String) {
    val sdf = SimpleDateFormat("MM/dd/yyyy")
    var epoch =
        java.text.SimpleDateFormat("MM/dd/yyyy").parse(sdf.format(input))!!.time / 1000
    println(epoch)
}


/*
    val sdf = SimpleDateFormat("MM/dd/yyyy", "US")

    val netDate = Date().getTime()
    var unixTime = System.currentTimeMillis() / 1000L
*/

    fun populate(id:Int) {
        //get the receipt object at the list id
        var currentReceipt = ReceiptsMockData.receiptList[id] as Receipts

        ev_merchant_name.setText(currentReceipt.merchantName)
        ev_category.setText(currentReceipt.category)
        //TODO:proper formatting for date and money, should be able to grab a freeware class for both thrings -- or may be handled inkotlin alreayd
        // either way come back to this
        ev_date.setText(fromDateLong(currentReceipt.date)).toString()
        ev_amount.setText(currentReceipt.cost.toString())
        tv_mock_id.text =currentReceipt.mockID.toString()
        //TODO: return here once we get images for rceipts

        //if it's a mock receipt/no image specified set as appropriate resource file, otherwise set as uri
        if(currentReceipt.receiptImage != 0) {
            iv_receipt_image.setImageResource(currentReceipt.receiptImage)
        }
        else {
            iv_receipt_image.setImageURI(currentReceipt.receiptImageURI.toUri())
        }
    }


 fun saveChanges(id:Int) {
     //this may eventually have data sanity checks and perhaps a dialog box to communicate with user
     /*
        var fullName:String,
        var category:String,
        var merchantName:String,
        var cost:Double,
        var date: Long,
        var mockID:Int,
        var receiptImage:Int*/
     //update once we have formating
     var date: Long = 165655644 //ev_date,
     var cost: Double = 45.12 // ev_amount
     var newReceipt = Receipts(
         "",
         ev_category.text.toString(),
         ev_merchant_name.text.toString(),
         cost,
         date,
         id,
         0,
         uriS)
     receiptList.add(id,newReceipt)
 }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(EDIT_RECEIPT) ?: -1
            newID = it.getInt(ADD_NEW_RECEIPT) ?: -1
        }
        Log.i("id= $id  ", "newID= $newID")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.edit_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        if (id != -1) { // else if and else are likely redundant
            populate(id as Int)
            NEW_ITEM_FLAG=false
        }
        else {  //this should never trigger
            newID = receiptList.size
            NEW_ITEM_FLAG=true
        }

        btn_submit.setOnClickListener {
            if (id != -1) {
                saveChanges(id as Int)
            }
            else {
                saveChanges(newID as Int)
            }
        }


        btn_edit_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "image/*"
            }
            // all code Intent.ACTION_OPEN_DOCUMENT
            startActivityForResult(intent, READ_REQUEST_CODE)
        }





        /*
                *   Code for previous and next buttons,
                *   cut as of 9:43am on the 28th,
                *   can we add relatively trivially
        btn_previous_edit.setOnClickListener {
            if (id>=1){
                id--
            }
            else {
                id=receiptList.size-1
            }
            populate(id)
        }
        btn_next_edit.setOnClickListener {
            if (id < receiptList.size -1){
                id++
            }
            else {
                id=0
            }
            populate(id)
        }
*/



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            resultData?.data?.also { uri ->
                Log.i("2legs", "Uri: $uri")
                iv_receipt_image.setImageURI(uri)
                uriS = uri.toString()
               // showImage(uri)
            }
        }
    }

        // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onEditFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnEditFragmentListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnDetailsFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnEditFragmentListener {
        // TODO: Update argument type and name
        fun onEditFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(editId: Int, new: Int?) =
            EditFragment().apply {
                arguments = Bundle().apply {
                    putInt(EDIT_RECEIPT, editId)
                   if(new!=null) {
                       putInt(ADD_NEW_RECEIPT, new)
                   }
                }
            }
    }
}
