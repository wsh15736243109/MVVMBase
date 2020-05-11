package com.cr.myapplication.extension

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.cr.myapplication.utils.EmptyCornerDrawable


fun ImageView.displayWithUrl(url: String?, radius: Float) {
    val radiusPx = radius.dp2IntPx(context)
    val empty = EmptyCornerDrawable(0xff969696.toInt(), radiusPx.toFloat())
    Glide.with(this).load(url)
        .apply(
            RequestOptions().transforms(
                CenterCrop(),
                RoundedCorners(radiusPx)
            )
                .placeholder(empty).error(
                    empty
                )
        )
        .into(this)
}

fun ImageView.displayWithUrl(url: String?) {
    val empty = EmptyCornerDrawable(0xff969696.toInt(), 0f)
    Glide.with(this).load(url)
        .apply(
            RequestOptions().transforms(
                CenterCrop()
            )
                .placeholder(empty).error(
                    empty
                )
        )
        .into(this)
}

fun ImageView.displayWithResource(uri: Int?, radius: Float) {
    val radiusPx = radius.dp2IntPx(context)
    val empty = EmptyCornerDrawable(0xff969696.toInt(), radiusPx.toFloat())
    Glide.with(this).load(uri)
        .apply(
            RequestOptions().transforms(
                CenterCrop(),
                RoundedCorners(radiusPx)
            )
                .placeholder(empty).error(
                    empty
                )
        )
        .into(this)
}

fun EditText.hideKeyboard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}