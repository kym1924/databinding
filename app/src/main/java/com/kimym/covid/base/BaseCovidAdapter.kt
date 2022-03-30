package com.kimym.covid.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.kimym.covid.R
import com.kimym.covid.data.entity.SealedInformation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class BaseCovidAdapter(@LayoutRes private val layoutRes: Int) :
    ListAdapter<SealedInformation, BaseViewHolder>(
        BaseDiffUtilItemCallback(
            itemsTheSame = { oldItem, newItem -> oldItem.seq == newItem.seq },
            contentsTheSame = { oldItem, newItem -> oldItem == newItem }
        )
    ) {
    val adapterScope = CoroutineScope(Dispatchers.Default)

    abstract fun addHeaderAndSubmitList(list: List<*>?)

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            when (viewType) {
                0 -> createBinding(parent, R.layout.item_header)
                else -> createBinding(parent, layoutRes)
            }
        )
    }

    private fun createBinding(parent: ViewGroup, @LayoutRes layoutRes: Int): ViewDataBinding {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DataBindingUtil.inflate(layoutInflater, layoutRes, parent, false)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bind(holder, position)
    }

    abstract fun bind(holder: BaseViewHolder, position: Int)
}
