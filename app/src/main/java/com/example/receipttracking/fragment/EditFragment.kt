package com.example.receipttracking.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ListActivity
import android.content.Context
import android.content.Intent
import android.icu.text.NumberFormat
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
import com.example.receipttracking.activities.DetailsActivity.Companion.KEY_RECEIPT
import com.example.receipttracking.activities.DetailsActivity.Companion.NEW_ITEM_FLAG
import com.example.receipttracking.model.Receipts
import com.example.receipttracking.model.ReceiptsMockData
import com.example.receipttracking.model.ReceiptsMockData.Companion.receiptList
import com.example.receipttracking.model.utils.Companion.fromDateLong
import com.example.receipttracking.model.utils.Companion.toDateLong
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.details_fragment.iv_receipt_image
import kotlinx.android.synthetic.main.details_fragment.tv_mock_id
import kotlinx.android.synthetic.main.edit_fragment.*
import java.text.SimpleDateFormat
import java.util.*








class EditFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var editID: Int? = null ?: -1
    private var newID: Int? = null ?: -1
    private var listener: OnEditFragmentListener? = null
    private var uriS:String = ""
    @SuppressLint("NewApi")
    var mCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US)


/*
    val netDate = Date().getTime()
    var unixTime = System.currentTimeMillis() / 1000L
*/

    @SuppressLint("NewApi")
    fun populate(id:Int) {
        //get the receipt object at the list editID
        var currentReceipt = ReceiptsMockData.receiptList[id] as Receipts

        ev_merchant_name.setText(currentReceipt.merchantName)
        ev_category.setText(currentReceipt.category)
        //TODO:proper formatting for date and money, should be able to grab a freeware class for both thrings -- or may be handled inkotlin alreayd
        // either way come back to this
        ev_date.setText(fromDateLong(currentReceipt.date)).toString()
        ev_amount.setText(mCurrencyFormat.format(currentReceipt.cost).toString())
        tv_mock_id.text =currentReceipt.mockID.toString()

        //if it's a mock receipt/no image specified set as appropriate resource file, otherwise set as uri
        if(currentReceipt.receiptImage != 0) {
            iv_receipt_image.setImageResource(currentReceipt.receiptImage)
        }
        else {
            iv_receipt_image.setImageURI(currentReceipt.receiptImageURI.toUri())
        }
    }


 fun saveChanges(id:Int) {

     var date= System.currentTimeMillis() / 1000L //toDateLong(ev_date.text.toString()) ?
     var cost: Double = 55.00 //ev_amount.text.toString().toDouble()
     var newReceipt = Receipts(
         "",
         ev_category.text.toString(),
         ev_merchant_name.text.toString(),
         cost,
         date,
         id,
         0,
         uriS)
     if (NEW_ITEM_FLAG) {
         receiptList.add(newReceipt)
         recycler_view.adapter!!.notifyDataSetChanged()
         NEW_ITEM_FLAG=false
     }
     else{
         receiptList[id]=newReceipt
         recycler_view.adapter!!.notifyItemChanged(id)
     }
 }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            editID = it.getInt(EDIT_RECEIPT) ?: -1
            newID = it.getInt(ADD_NEW_RECEIPT) ?: -1
        }
        Log.i("editID= $editID  ", "newID= $newID")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.edit_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       if (NEW_ITEM_FLAG) {
            editID = receiptList.size-1
        }
        else {
            populate(editID as Int)
            NEW_ITEM_FLAG=true
        }

        btn_submit.setOnClickListener {
            if (editID != -1) {
                saveChanges(editID as Int)
                val intent = Intent(view.context, ListActivity::class.java)
                startActivity(intent)
            }
        }


        btn_edit_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "image/*"
            }
            // alt code Intent.ACTION_OPEN_DOCUMENT
            startActivityForResult(intent, KEY_RECEIPT)
        }





        /*
                *   Code for previous and next buttons,
                *   cut as of 9:43am on the 28th,
                *   can we add relatively trivially
        btn_previous_edit.setOnClickListener {
            if (editID>=1){
                editID--
            }
            else {
                editID=receiptList.size-1
            }
            populate(editID)
        }
        btn_next_edit.setOnClickListener {
            if (editID < receiptList.size -1){
                editID++
            }
            else {
                editID=0
            }
            populate(editID)
        }
*/



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == KEY_RECEIPT && resultCode == Activity.RESULT_OK) {
            resultData?.data?.also { uri ->
                Log.i("2legs", "Uri: $uri")
                iv_receipt_image.setImageURI(uri)
                uriS = uri.toString()
               // showImage(uri)
            }
        }
    }


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

    interface OnEditFragmentListener {
        fun onEditFragmentInteraction(uri: Uri)
    }

    companion object {
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
