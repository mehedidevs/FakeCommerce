package com.mehedi.fakecommerce.ui.home


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mehedi.fakecommerce.R
import com.mehedi.fakecommerce.base.BaseFragment
import com.mehedi.fakecommerce.databinding.FragmentHomeBinding
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
        findNavController().navigate(R.id.action_home_screen_desing_to_detailsFragment)
    }


}