package com.mehedi.fakecommerce.repos

import android.util.Log
import com.mehedi.fakecommerce.api.ProductService
import com.mehedi.fakecommerce.data.cart.ResponseCartItem
import com.mehedi.fakecommerce.data.product.ResponseProductItem
import retrofit2.Response
import javax.inject.Inject

class ProductRepo @Inject constructor(private val service: ProductService) {


    suspend fun getAllProduct(): Response<List<ResponseProductItem>> {
        return service.getAllProduct()
    }

    suspend fun getProductById(id: Int): Response<ResponseProductItem> {
        var data = service.getProductById(id)

        Log.d("TAG", "getProductById: ${data.body()} ")

        return data

    }

    suspend fun getAllCart(): Response<List<ResponseCartItem>> {

        return service.getAllCart(2)

    }

}