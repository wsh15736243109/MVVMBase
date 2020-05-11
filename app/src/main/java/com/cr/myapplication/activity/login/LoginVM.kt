package com.cr.myapplication.activity.login

import androidx.lifecycle.MutableLiveData
import com.baseandroidlibrary.UIUtils.ToastUtil.ToastUtil
import com.cr.myapplication.application.App.Companion.instance
import com.cr.myapplication.base.BaseViewModel

class LoginVM : BaseViewModel() {
    val userName = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val loginStatus = MutableLiveData<Boolean>()
    fun login() {
        if (userName.value.isNullOrEmpty()) {
            ToastUtil.showToast(instance, "用户名为空")
//            return
        }
        if (password.value.isNullOrEmpty()) {
            ToastUtil.showToast(instance, "密码为空")
//            return
        }
        loginStatus.value = true
    }
}