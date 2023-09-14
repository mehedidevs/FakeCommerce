package com.mehedi.fakecommerce.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mehedi.fakecommerce.data.product.ResponseProductItem
import com.mehedi.fakecommerce.databinding.RecommendedBinding

class HomeAdapter(private val listener: Listener) :
    ListAdapter<ResponseProductItem, HomeAdapter.VH>(COMPARATOR) {

    interface Listener {


        fun itemClick(id: Int)

    }


    class VH(val binding: RecommendedBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(RecommendedBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position).let {

            holder.binding.apply {

                reImg.load(it.image)
                textView.text = it.title
                price.text = "$${it.price}"
                textView3.text = it.description
                textView6.text = it.category
                textView4.text = "(${it.rating?.rate})"
                textView5.text = "${it.rating?.count}"


                holder.itemView.setOnClickListener {

                    listener.itemClick(it.id)

                }


            }


        }
    }


    companion object {


        var COMPARATOR = object : DiffUtil.ItemCallback<ResponseProductItem>() {
            override fun areItemsTheSame(
                oldItem: ResponseProductItem,
                newItem: ResponseProductItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ResponseProductItem,
                newItem: ResponseProductItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

        }


    }


}