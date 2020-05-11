package com.cr.myapplication

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.MutableLiveData
import com.baseandroidlibrary.UIUtils.ToastUtil.ToastUtil
import com.cr.myapplication.application.App.Companion.instance
import com.cr.myapplication.base.BaseViewModel

class MainVM : BaseViewModel() {
    var keyWord = MutableLiveData<String>()
    var loginStatus = MutableLiveData<Boolean>()
    var imageResource = R.mipmap.ic_launcher
    var imageUrl = "http://img1.imgtn.bdimg.com/it/u=4082803480,4238601085&fm=15&gp=0.jpg"

    fun changeData() {
//        keyWord.value = "正在改"
        loginStatus.value = true
    }

    fun search() {
        ToastUtil.showToast(instance, "开始搜索")
    }

    var textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            println(s)
        }

    }
}