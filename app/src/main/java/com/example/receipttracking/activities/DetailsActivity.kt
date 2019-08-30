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
       const val ADD_NEW_RECEIPT = "2"
       const val EDIT_RECEIPT = "3"
       const val KEY_RECEIPT = 1
       var NEW_ITEM_FLAG =false

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
}