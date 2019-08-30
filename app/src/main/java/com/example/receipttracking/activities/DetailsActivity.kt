package com.example.receipttracking.activities


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.receipttracking.R
import com.example.receipttracking.fragment.DetailsFragment
import com.example.receipttracking.fragment.EditFragment

class DetailsActivity : AppCompatActivity(), DetailsFragment.OnDetailsFragmentListener, EditFragment.OnEditFragmentListener {

/*
*
* when user is transfer to the details activity
* depending on the content of the intents, they will be either sent
* to a blank edit fragment to make a new receipt
* or a details fragment to view an old receipt
*
* */

// the values here are used to communicate within the app as to the current goals of the users actions
   companion object {
       const val ADD_NEW_RECEIPT = "2"
       const val EDIT_RECEIPT = "3"
       const val KEY_RECEIPT = 1
       var NEW_ITEM_FLAG =false

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)



        var new = intent.getIntExtra(ADD_NEW_RECEIPT, -1)
        var edit = intent.getIntExtra(EDIT_RECEIPT,-1)

        if (edit == -1){
            var fragment = EditFragment.newInstance(-1,1)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_holder, fragment)
                .commit()
        }
        else {
            var fragment = DetailsFragment.newInstance(edit)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_holder, fragment)
                .commit()
        }


    }
    override fun onDetailsFragmentInteraction(uri: Uri) {
    }
    override fun onEditFragmentInteraction(uri: Uri) {
    }
}
