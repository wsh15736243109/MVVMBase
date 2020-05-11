package com.cr.myapplication

import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.baseandroidlibrary.UIUtils.ToastUtil.ToastUtil
import com.cr.myapplication.base.BaseMVVMActivity
import com.cr.myapplication.bean.LoginBean
import com.cr.myapplication.bean.RegisterBean
import com.cr.myapplication.databinding.ActivityMainBinding
import com.cr.myapplication.extension.viewModel
import com.cr.myapplication.route.RoutePath.Companion.loginAC
import com.cr.myapplication.route.RouteUtil.Companion.activityTo

class MainActivity : BaseMVVMActivity<ActivityMainBinding, MainVM>() {

    override val layoutId: Int
        get() = R.layout.activity_main
    val vm by viewModel<MainVM>()
    override fun initData() {
        binding.vm = vm
        vm.keyWord.value = "劳资腰改了"
        vm.keyWord.observeForever {
            ToastUtil.showToast(this, it)
        }
        var loginBean = LoginBean("qqqqq", "1538564646")
        var registerBean = RegisterBean("嗯嗯")
        var result = with(loginBean) {
            registerBean
        }
        println("result: $result")
        vm.keyWord.value = result.toString()
        vm.loginStatus.observeForever {
            if (it) {
                var bundle = Bundle()
                bundle.putString("name", "张三")
                bundle.putBoolean("isSingle", true)
                bundle.putInt("age", 22)
                activityTo(this, loginAC, bundle, 111, object : NavigationCallback {
                    override fun onLost(postcard: Postcard?) {
                    }

                    override fun onFound(postcard: Postcard?) {
                    }

                    override fun onInterrupt(postcard: Postcard?) {
                    }

                    override fun onArrival(postcard: Postcard?) {
                    }
                })
//                activityTo(this, loginAC, bundle, 111, object : Callback {
//                    override fun onActivityResult(
//                        requestCode: Int,
//                        resultCode: Int,
//                        data: Intent?
//                    ) {
//
//                    }
//
//                })
            } else {

            }
        }
    }

}
