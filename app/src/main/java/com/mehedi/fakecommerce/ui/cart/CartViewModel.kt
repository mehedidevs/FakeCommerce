package com.mehedi.fakecommerce.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.fakecommerce.data.cart.ResponseCartItem
import com.mehedi.fakecommerce.repos.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val repo: ProductRepo) : ViewModel() {

    private var _allCartResponse = MutableLiveData<List<ResponseCartItem>>()
    val allCartResponse: LiveData<List<ResponseCartItem>>
        get() = _allCartResponse


    init {
        getAllCart()
    }


    private fun getAllCart() {
        viewModelScope.launch {
            val response = repo.getAllCart()
            if (response.isSuccessful) {
                _allCartResponse.postValue(response.body())
            }
        }
    }


}