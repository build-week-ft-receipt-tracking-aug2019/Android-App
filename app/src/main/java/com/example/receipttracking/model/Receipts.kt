package com.example.receipttracking.model

import java.io.Serializable


data class Receipts(
    var fullName:String,
    var category:String,
    var merchantName:String,
    var cost:Double,
    var date: Long,
    var mockID:Int,
    var receiptImage:Int,
    var receiptImageURI: String,
    var favorite:Boolean
) : Serializable