package com.example.receipttracking.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.receipttracking.R
import com.example.receipttracking.model.Receipts
import com.example.receipttracking.model.ReceiptsMockData
import kotlinx.android.synthetic.main.details_fragment.*
import kotlinx.android.synthetic.main.details_fragment.iv_receipt_image
import kotlinx.android.synthetic.main.details_fragment.tv_mock_id
import kotlinx.android.synthetic.main.edit_fragment.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnEditFragmentListener? = null



    fun populate(id:Int) {


        //get the receipt object at the list id
        var currentReceipt = ReceiptsMockData.receiptList[id] as Receipts

        ev_merchant_name.hint = currentReceipt.merchantName
        ev_category.hint = currentReceipt.category
        //TODO:proper formatting for date and money, should be able to grab a freeware class for both thrings -- or may be handled inkotlin alreayd
        // either way come back to this
        ev_date.hint = currentReceipt.date.toString()
        ev_amount.hint = currentReceipt.cost.toString()
        tv_mock_id.hint =currentReceipt.mockID.toString()
        //TODO: return here once we get images for rceipts
        iv_receipt_image.setImageResource(R.drawable.ic_launcher_foreground)

    }




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
        return inflater.inflate(R.layout.edit_fragment, container, false)
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
            EditFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
