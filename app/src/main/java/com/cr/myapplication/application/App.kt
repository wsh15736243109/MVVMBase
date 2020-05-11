package com.cr.myapplication.application

import com.baseandroidlibrary.application.BaseApplication

class App : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        initArouter()
    }

    private fun initArouter() {
    }

    override fun initConfigApp() {

    }

    companion object {
        lateinit var instance: App
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}