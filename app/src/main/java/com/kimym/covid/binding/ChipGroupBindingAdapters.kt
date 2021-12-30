package com.kimym.covid.binding

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.google.android.material.chip.ChipGroup

@BindingAdapter("checked")
fun ChipGroup.setChecked(checked: Int) {
    if (checkedChipId != checked) {
        check(checked)
    }
}

@InverseBindingAdapter(attribute = "checked", event = "chipChecked")
fun ChipGroup.getChecked(): Int {
    return checkedChipId
}

@BindingAdapter("chipChecked")
fun ChipGroup.setListeners(listener: InverseBindingListener?) {
    setOnCheckedChangeListener { _, _ ->
        listener?.onChange()
    }
}
