package com.mehedi.fakecommerce.ui.home


import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.mehedi.fakecommerce.base.BaseFragment
import com.mehedi.fakecommerce.databinding.FragmentHomeBinding
import com.mehedi.fakecommerce.ui.cart.CartViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    HomeAdapter.Listener {

    private val viewModel: HomeViewModel by activityViewModels()
    private val adapter: HomeAdapter by lazy {
        HomeAdapter(this@HomeFragment)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allProductResponse.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.recommendedRcv.adapter = adapter


        }


    }

    override fun itemClick(id: Int) {
        viewModel.getProductById(id)

    }


}