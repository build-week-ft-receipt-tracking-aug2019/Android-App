package com.example.receipttracking.model

import java.text.SimpleDateFormat
import java.util.*

class utils {
    companion object {
        fun fromDateLong(timeStampStr: Long): String {
            try {
                val sdf = SimpleDateFormat("MM/dd/yyyy")
                val netDate = Date(timeStampStr * 1000)

                return sdf.format(netDate)
            } catch (ex: Exception) {
                return timeStampStr.toString()
            }
        }

        fun toDateLong(input: String) {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            var epoch =
                java.text.SimpleDateFormat("MM/dd/yyyy").parse(sdf.format(input))!!.time / 1000
            println(epoch)
        }
    }

}