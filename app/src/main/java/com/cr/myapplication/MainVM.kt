package com.cr.myapplication

import androidx.lifecycle.MutableLiveData
import com.cr.myapplication.base.BaseViewModel

class MainVM : BaseViewModel() {
    var keyWord = MutableLiveData<String>()
    var loginStatus = MutableLiveData<Boolean>()

    fun changeData() {
//        keyWord.value = "正在改"
        loginStatus.value = true
    }
}