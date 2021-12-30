package com.kimym.covid.binding

import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleOrNot")
fun View.visibleOrNot(visible: Boolean) {
    visibility = when (visible) {
        true -> View.VISIBLE
        false -> View.INVISIBLE
    }
}

@BindingAdapter(value = ["redTextFormat", "redTextValue", "startPosition"], requireAll = true)
fun TextView.redText(format: String, value: String, startPosition: Int) {
    val str = String.format(format, value)
    text = SpannableStringBuilder(str).apply {
        setSpan(
            ForegroundColorSpan(Color.RED),
            startPosition,
            length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        setSpan(
            StyleSpan(Typeface.BOLD),
            startPosition, length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
}
