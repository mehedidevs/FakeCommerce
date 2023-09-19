package com.mehedi.fakecommerce.api

import com.mehedi.fakecommerce.data.cart.ResponseCartItem
import com.mehedi.fakecommerce.data.product.ResponseProductItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {


    @GET("products")
    suspend fun getAllProduct(): Response<List<ResponseProductItem>>

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): Response<ResponseProductItem>


    @GET("carts/user/{id}")
    suspend fun getAllCart( @Path("id") id: Int): Response<List<ResponseCartItem>>


}
