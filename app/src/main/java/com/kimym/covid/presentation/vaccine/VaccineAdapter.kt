package com.kimym.covid.presentation.vaccine

import com.kimym.covid.BR
import com.kimym.covid.R
import com.kimym.covid.base.BaseCovidAdapter
import com.kimym.covid.base.BaseViewHolder
import com.kimym.covid.data.entity.SealedInformation
import com.kimym.covid.data.entity.VaccineLevelEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VaccineAdapter : BaseCovidAdapter(R.layout.item_vaccine_region) {
    override fun addHeaderAndSubmitList(list: List<*>?) {
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(SealedInformation.Header)
                else -> listOf(SealedInformation.Header) +
                        list.map { SealedInformation.VaccineItem(it as VaccineLevelEntity) }
            }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    override fun bind(holder: BaseViewHolder, position: Int) {
        if (position != 0) {
            val item = getItem(position) as SealedInformation.VaccineItem
            holder.binding.setVariable(BR.vaccineLevelEntity, item.vaccineLevelEntity)
            holder.binding.executePendingBindings()
        }
    }
}
