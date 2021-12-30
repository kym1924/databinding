package com.kimym.covid.util

import java.text.SimpleDateFormat
import java.util.Locale

object FormatDateUtil {
    private val currentTimeMillis = System.currentTimeMillis()
    private val yesterday = currentTimeMillis - (60 * 60 * 24 * 1000)

    fun getFormatDate(pattern: String): String {
        return when (hourCheck()) {
            true -> dateFormat(pattern, yesterday)
            else -> dateFormat(pattern, currentTimeMillis)
        }
    }

    fun getFormatYesterday(): String {
        val pattern = "MM.dd"
        return when (hourCheck()) {
            true -> dateFormat(pattern, yesterday - (60 * 60 * 24 * 1000))
            else -> dateFormat(pattern, yesterday)
        }
    }

    private fun hourCheck(): Boolean {
        val hour = SimpleDateFormat("HH", Locale.KOREA).format(currentTimeMillis)
        return hour.toInt() < 10
    }

    private fun dateFormat(pattern: String, time: Long): String {
        val dateFormat = SimpleDateFormat(pattern, Locale.KOREA)
        return dateFormat.format(time)
    }
}
