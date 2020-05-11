package com.baseandroidlibrary.Utils.androidUtils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.baseandroidlibrary.beanBase.MobileModel;

/**
 * Created by zy on 2018/6/13.
 */

public class AndroidUtils {

    /*
     *@return true:网络可用; false:网络不可用
     */
    public static boolean isOpenNetWork(Context context) {
        /*
         ConnectivityManager：关于网络状态的查询（Class that answers queries about the state of network connectivity）
         NetworkInfo：描述了网络接口的状态；
         */
        ConnectivityManager conManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        @SuppressLint("MissingPermission") NetworkInfo activeNetworkInfo = conManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    public static MobileModel getMobileModel() {
        String model = android.os.Build.MODEL;//设备型号
        String carrier = android.os.Build.MANUFACTURER;//厂家
        MobileModel mobileModel = new MobileModel();
        mobileModel.setManufacturer(carrier);
        mobileModel.setModel(model);
//        System.out.println(model + "机型" + carrier);
        return mobileModel;
    }

    //是否有摄像头
    public static boolean isSupportCamera(Context context) {
        PackageManager pm = context.getPackageManager();
        return /*pm.hasSystemFeature(PackageManager.FEATURE_CAMERA) || pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT) ||
                Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD ||*/ Camera.getNumberOfCameras() > 0;
    }

    //是否有麦克风
    public static boolean isSupportVoice(Context context) {
        return /*context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_MICROPHONE)*/true;
    }

    public static String getAppVersion(Context context) {
        PackageInfo packageInfo = null;
        String localVersion = "";
        try {
            packageInfo = context
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            localVersion = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return localVersion;
    }

    public static void claseMic(Context context) {
        //获取音频服务
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        //设置声音模式
        audioManager.setMode(AudioManager.STREAM_MUSIC);
        //关闭麦克风
        audioManager.setMicrophoneMute(false);
    }
}
