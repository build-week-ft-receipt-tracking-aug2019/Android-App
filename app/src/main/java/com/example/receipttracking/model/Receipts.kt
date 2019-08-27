package com.example.receipttracking.model

import java.util.*

data class Receipts (
    var fullName:String,
    var category:String,
    var merchantName:String,
    var cost:Double,
    var date: Long,
    var mockID:Int,
    var receiptImage:Int
)