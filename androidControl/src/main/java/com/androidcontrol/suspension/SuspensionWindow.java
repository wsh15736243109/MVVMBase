package com.androidcontrol.suspension;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by zy on 2017/7/17.
 * 悬浮窗操作.
 */
public class SuspensionWindow {

    private WindowManager mWindowManager = null;
    private Context mContext = null;
    private View mView = null;
    private SetParams setParams;
    private WindowManager.LayoutParams params;
    private boolean isDisplay = false;


    public SuspensionWindow(Context context){
        init(context);
    }

    private void init(Context context){
        this.mContext = context;
    }

    public void createWindow(){
        createWindow(0,0, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    public void createWindow(int x,int y,int width,int height){
        // 获取WindowManager
        mWindowManager = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);
        params = new WindowManager.LayoutParams();
        // 类型
        params.type = WindowManager.LayoutParams.TYPE_APPLICATION;
        int flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        params.flags = flags;
        params.width = width;
        params.height = height;
        params.gravity = Gravity.LEFT | Gravity.TOP;
        params.alpha = 1f;
        params.x = x;
        params.y = y;
        if (setParams!=null){
            setParams.setParams(params);
        }
        isDisplay = true;
        //mWindowManager.addView(mView, params);
    }


    /**
     * 设置View.
     * @param layout
     * @return
     */
    public View setView(int layout) {
        View view = LayoutInflater.from(mContext).inflate(layout,
                null);
        this.mView = view;
        return view;
    }

    /**
     * 设置param.
     * @param setParams
     */
    public void setSetParams(SetParams setParams){
        this.setParams = setParams;
    }

    /**
     * 隐藏弹出框
     */
    public void hidePopupWindow() {
        if (null != mView&&mWindowManager!=null) {
            mWindowManager.removeView(mView);
            isDisplay = false;
        }
    }

    /**
     * 显示弹出框
     */
    public void PopupWindow() {
        if (null != mView&&mWindowManager!=null) {
            mWindowManager.addView(mView, params);
            isDisplay = true;
        }
    }

    /**
     * 更新悬浮窗.
     * @param layout
     * @return
     */
    public View UpdateView(int layout){
        if (mWindowManager!=null){
            if (setParams!=null){
                setParams.setParams(params);
            }
            setView(layout);
            mWindowManager.updateViewLayout(mView,params);
            isDisplay = true;
        }
        return mView;
    }

    public interface SetParams {
        public void setParams(WindowManager.LayoutParams params);
    }

    public boolean isDisplay() {
        return isDisplay;
    }
}
