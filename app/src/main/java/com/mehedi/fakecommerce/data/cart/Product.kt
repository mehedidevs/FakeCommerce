package com.mehedi.fakecommerce.data.cart


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("productId")
    var productId: Int?,
    @SerializedName("quantity")
    var quantity: Int?
)