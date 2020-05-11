package com.cr.myapplication.route

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter

class RouteUtil {
    companion object {

        fun activityTo(context: Context, path: String) {
            ARouter.getInstance().build(path).navigation(context)
        }

        fun activityTo(context: Context, path: String, bundle: Bundle) {
            ARouter.getInstance().build(path).with(bundle).navigation(context)
        }

        //        /**
//         *
//         */
        fun activityTo(
            context: Activity,
            path: String,
            requestCode: Int,
            callback: NavigationCallback
        ) {
            ARouter.getInstance().build(path)
                .navigation(
                    context,
                    requestCode, object : NavigationCallback {
                        override fun onLost(postcard: Postcard?) {

                        }

                        override fun onFound(postcard: Postcard?) {

                        }

                        override fun onInterrupt(postcard: Postcard?) {

                        }

                        override fun onArrival(postcard: Postcard?) {

                        }

                    }
                )
        }

        //
        fun activityTo(
            context: Activity,
            path: String,
            bundle: Bundle,
            requestCode: Int,
            callback: NavigationCallback
        ) {
            ARouter.getInstance().build(path).with(bundle)
                .navigation(
                    context,
                    requestCode, object : NavigationCallback {
                        override fun onLost(postcard: Postcard?) {
                            callback.onLost(postcard)
                        }

                        override fun onFound(postcard: Postcard?) {
                            callback.onFound(postcard)
                        }

                        override fun onInterrupt(postcard: Postcard?) {
                            callback.onInterrupt(postcard)
                        }

                        override fun onArrival(postcard: Postcard?) {
                            callback.onArrival(postcard)
                        }
                    }
                )
        }
    }
}

