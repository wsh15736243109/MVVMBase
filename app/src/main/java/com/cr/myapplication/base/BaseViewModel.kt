package com.cr.myapplication.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import java.util.*

open class BaseViewModel :ViewModel() {

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    open fun startActivity(clz: Class<*>, bundle: Bundle?) {
        val params: MutableMap<String, Any> =
            HashMap()
        params[BaseViewModel.ParameterField.CLASS] = clz
        if (bundle != null) {
            params[BaseViewModel.ParameterField.BUNDLE] = bundle
        }
    }



    object ParameterField {
        var CLASS = "CLASS"
        var CANONICAL_NAME = "CANONICAL_NAME"
        var BUNDLE = "BUNDLE"
    }
}