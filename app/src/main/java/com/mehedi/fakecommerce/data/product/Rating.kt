package com.mehedi.fakecommerce.data.product


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("count")
    var count: Int?,
    @SerializedName("rate")
    var rate: Double?
)