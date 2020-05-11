package com.cr.myapplication.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.launcher.ARouter
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

abstract class BaseMVVMActivity<T : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {
    private var viewModelId = 0
    lateinit var binding: T
    abstract val layoutId: Int

    //    lateinit var vm: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        ARouter.getInstance().inject(this)
//        initVM()
        initData()
    }

    fun initVM() {
        val modelClass: Class<ViewModel>
        val type: Type = javaClass.genericSuperclass
        modelClass = (if (type is ParameterizedType) {
            (type as ParameterizedType).actualTypeArguments[1] as Class<ViewModel>
        } else {
            //如果没有指定泛型参数，则默认使用BaseViewModel
            BaseViewModel::class.java
        }) as Class<ViewModel>
        //ViewModelProviders.of(this).get(clazz::class.java) as VM
//        vm = createViewModel(this, modelClass) as VM
    }

    /**
     * 创建ViewModel
     *
     * @param cls
     * @param <T>
     * @return
    </T> */
    open fun <T : ViewModel?> createViewModel(
        activity: FragmentActivity?,
        cls: Class<T>?
    ): T {
        return ViewModelProviders.of(activity!!).get(cls!!)
    }


    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    abstract fun initData()
}
