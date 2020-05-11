package com.cr.myapplication.route

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.github.iamyours.router.ARouter
import io.github.iamyours.router.Callback
import io.github.iamyours.router.Postcard

class RouteUtil {
    companion object {

        fun activityTo(context: Context, path: String) {
            ARouter.getInstance().build(path).navigation(context)
        }

        fun activityTo(context: Context, path: String, bundle: Bundle) {
            ARouter.getInstance().build(path).with(bundle).navigation(context)
        }

        /**
         *
         */
        fun activityTo(
            context: Activity,
            path: String,
            requestCode: Int,
            callback: Callback
        ) {
            ARouter.getInstance().build(path)
                .navigation(
                    context,
                    requestCode
                ) { requestCode, resultCode, data -> callback.onActivityResult(requestCode,resultCode,data) }
        }

        @JvmOverloads
        fun activityTo(
            context: Activity,
            path: String,
            bundle: Bundle,
            requestCode: Int,
            callback: Callback
        ) {
            ARouter.getInstance().build(path).with(bundle)
                .navigation(
                    context,
                    requestCode
                ) { requestCode, resultCode, data -> callback.onActivityResult(requestCode,resultCode,data) }
        }
    }
}

