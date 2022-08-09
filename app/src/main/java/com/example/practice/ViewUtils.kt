package com.example.practice

import android.view.View
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter

@BindingAdapter("variable_weight")
fun setAdapter(view: View, weight: Float) {
    val params =
    (view.layoutParams as (LinearLayout.LayoutParams))
    params.weight = weight
    view.layoutParams = params
}