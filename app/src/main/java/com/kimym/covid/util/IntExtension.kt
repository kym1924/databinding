package com.kimym.covid.util

import java.text.DecimalFormat

fun Int.decimalFormat(): String {
    val decimalFormat = DecimalFormat("#,###")
    return decimalFormat.format(this)
}

fun Int.getPercentage(): String {
    val allCount = 51349116.0
    val decimalFormat = DecimalFormat("#.#")
    return decimalFormat.format(this / allCount * 100)
}
