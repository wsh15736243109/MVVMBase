package com.cr.myapplication.activity.login

import android.content.Intent
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.baseandroidlibrary.UIUtils.ToastUtil.ToastUtil
import com.cr.myapplication.R
import com.cr.myapplication.base.BaseMVVMActivity
import com.cr.myapplication.databinding.ActivityLoginBinding
import com.cr.myapplication.extension.viewModel
import com.cr.myapplication.route.RoutePath.Companion.loginAC

@Route(path = loginAC)
class LoginActivity : BaseMVVMActivity<ActivityLoginBinding, LoginVM>() {
    @JvmField
    @Autowired(name = "name")
    var name = ""

    @JvmField
    @Autowired(name = "age")
    var age = 0

    @JvmField
    @Autowired(name = "isSingle")
    var isSingle = false
    val vm by viewModel<LoginVM>(){

    }
    override fun initData() {
        binding.vm2 = vm
        binding.vm2!!.loginStatus!!.observeForever {
            if (it) {
                ToastUtil.showToast(this, "登录成功")
//                activityTo(this, newListAC)
                var data = Intent()
                data.putExtra("back", "yes")
                setResult(130000, data)
                finish()
            } else {
                ToastUtil.showToast(this, "登录失败")
            }
        }

    }


    override val layoutId: Int
        get() = R.layout.activity_login
}
