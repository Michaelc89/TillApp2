package com.michaelchrystal.tillapp2

class Product {

    var id: Int
    var productName: String
    var price: Double
    var barcode: String
    var quantity: Int
    var productUrl: String

    constructor(id: Int,productName: String,price: Double,barcode: String,quantity: Int,productUrl: String) {
        this.id = id
        this.productName = productName
        this.price = price
        this.barcode = barcode
        this.quantity = quantity
        this.productUrl = productUrl
    }




}