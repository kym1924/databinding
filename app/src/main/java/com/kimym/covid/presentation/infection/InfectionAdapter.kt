package com.kimym.covid.presentation.infection

import com.kimym.covid.BR
import com.kimym.covid.R
import com.kimym.covid.base.BaseCovidAdapter
import com.kimym.covid.base.BaseViewHolder
import com.kimym.covid.data.entity.InfectionEntity
import com.kimym.covid.data.entity.SealedInformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InfectionAdapter : BaseCovidAdapter(R.layout.item_infection_region) {
    override fun addHeaderAndSubmitList(list: List<*>?) {
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(SealedInformation.Header)
                else -> listOf(SealedInformation.Header) +
                        list.map { SealedInformation.InfectionItem(it as InfectionEntity) }
            }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    override fun bind(holder: BaseViewHolder, position: Int) {
        if (position != 0) {
            val item = getItem(position) as SealedInformation.InfectionItem
            holder.binding.setVariable(BR.infectionEntity, item.infectionEntity)
            holder.binding.executePendingBindings()
        }
    }
}
