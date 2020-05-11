package com.cr.myapplication.binds

import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.cr.myapplication.extension.displayWithResource
import com.cr.myapplication.extension.displayWithUrl
import com.cr.myapplication.extension.hideKeyboard

//加载本地图片
@BindingAdapter(value = ["imageId"])
fun bindImage(iv: ImageView, id: Int?) {
    if (id != null) {
        iv.setImageResource(id)
    }
}

//加载本地圆角图片
@BindingAdapter(value = ["uri", "radius"])
fun bindImage(iv: ImageView, uri: Int?, radius: Int) {
    if (uri != null) {
        iv.displayWithResource(uri, radius.toFloat())
    }
}

//加载网络图片
@BindingAdapter(value = ["url"])
fun bindImage(iv: ImageView, uri: String?) {
    if (uri != null) {
        iv.displayWithUrl(uri)
    }
}

//加载网络圆角图片
@BindingAdapter(value = ["url", "radius"])
fun bindImage(iv: ImageView, url: String?, radius: Int) {
    if (url != null) {
        iv.displayWithUrl(url, radius.toFloat())
    }
}

@BindingAdapter(value = ["searchAction"])
fun bindSearchAction(et: EditText, callback: () -> Unit) {
    et.setOnEditorActionListener { v, actionId, event ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            callback()
            et.hideKeyboard()
        }
        true
    }
}

//@BindingAdapter(value = ["onTextChange"])
//fun bindOnTextChange(et: EditText, callback: () -> Unit) {
//    et.addTextChangedListener(object : TextWatcher {
//        override fun afterTextChanged(s: Editable?) {
//            callback
//        }
//
//        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//        }
//
//        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//        }
//
//    })
//}
