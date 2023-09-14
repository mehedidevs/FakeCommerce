package com.mehedi.fakecommerce.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.fakecommerce.data.product.ResponseProductItem
import com.mehedi.fakecommerce.repos.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: ProductRepo) : ViewModel() {

    private var _allProductResponse = MutableLiveData<List<ResponseProductItem>>()
    val allProductResponse: LiveData<List<ResponseProductItem>>
        get() = _allProductResponse


    init {
        getAllProduct()
    }


    private fun getAllProduct() {
        viewModelScope.launch {
            val response = repo.getAllProduct()
            if (response.isSuccessful) {
                _allProductResponse.postValue(response.body())
            }
        }
    }


    private var _productResponse = MutableLiveData<ResponseProductItem>()
    val productResponse: LiveData<ResponseProductItem>
        get() = _productResponse



    fun getProductById(id: Int) {
        viewModelScope.launch {
            val response = repo.getProductById(1)

            Log.d("TAG", "getProductById: ${response.body()} ")

            if (response.isSuccessful) {
                _productResponse.postValue(response.body())

            }


        }
    }

}