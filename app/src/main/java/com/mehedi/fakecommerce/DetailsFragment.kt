package com.mehedi.fakecommerce

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.mehedi.fakecommerce.base.BaseFragment
import com.mehedi.fakecommerce.databinding.FragmentDetailsBinding
import com.mehedi.fakecommerce.ui.cart.CartViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val viewModel: CartViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.productResponse.observe(viewLifecycleOwner) {
//            Log.i("TAG", "onViewCreated:${it.toString()} ")
//
////
////            binding.apply {
////
////                reImg.load(it.image)
////                textView.text = it.title
////                price.text = "$${it.price}"
////                textView3.text = it.description
////                textView6.text = it.category
////                textView4.text = "(${it.rating?.rate})"
////                textView5.text = "${it.rating?.count}"
////            }
//        }


    }


}