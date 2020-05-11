package com.cr.myapplication.application

import com.alibaba.android.arouter.launcher.ARouter
import com.baseandroidlibrary.application.BaseApplication

class App : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        initArouter()
    }

    private fun initArouter() {
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }

    override fun initConfigApp() {

    }

    companion object {
        lateinit var instance: App
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }
}