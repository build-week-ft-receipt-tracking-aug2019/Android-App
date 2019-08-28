package com.example.receipttracking.model

import java.io.Serializable
import java.util.*

data class Receipts(
    var fullName:String,
    var category:String,
    var merchantName:String,
    var cost:Double,
    var date: Long,
    var mockID:Int,
    var receiptImageResource:Int,
    var receiptImageURI: String
) : Serializable