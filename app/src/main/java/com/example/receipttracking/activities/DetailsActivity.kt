package com.example.receipttracking.activities


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.receipttracking.R
import com.example.receipttracking.fragment.DetailsFragment
import com.example.receipttracking.fragment.EditFragment
import com.example.receipttracking.model.ReceiptsMockData

class DetailsActivity : AppCompatActivity(), DetailsFragment.OnDetailsFragmentListener, EditFragment.OnEditFragmentListener {

   companion object {
       const val ID_TRANSFER = "1"
       const val ADD_NEW_RECEIPT = "2"
       const val EDIT_RECEIPT = "3"
       const val KEY_RECEIPT = 1


    }
    override fun onDetailsFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onEditFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


/*
    *
    *   once we're stiching the two activities together, will have something like
    * if intent getstring "details"
    * replace main frame with details fragment with receiptList[getint]
    * if (intent.getString "edit")
    * replace main frame with  edit fragment with the id provided in getint
    *  else if intent getstring "add"
    * open edit fragment but  with blank entries
    * else:
    *  error message or similar
    *
    * */
        
            //////remove this asap
        ReceiptsMockData.fillList()
        println(ReceiptsMockData.receiptList)
            //////remove it!
        var fragment = EditFragment.newInstance(-1,1)
        var new = intent.getIntExtra(ADD_NEW_RECEIPT, -1)
        var edit = intent.getIntExtra(EDIT_RECEIPT,-1)
        if (edit != -1){
                DetailsFragment.newInstance(edit)
        }
        else {
            EditFragment.newInstance(-1,1)
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder, fragment)
            .commit()


    }
}