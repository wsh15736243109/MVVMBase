package com.androidcontrol.editText;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by zy on 2018/7/12.
 */

public class LeftRightEditText extends IconEditText{

    public Context context;

    public LeftRightEditText(Context context) {
        super(context);
        init(context);
    }

    public LeftRightEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LeftRightEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        displayAll();
    }

    /**
     * 设置左边图片资源id
     * @param id
     */
    public void setLefIcon(int id) {
        left = getResources().getDrawable(id);
        left.setBounds(0, 0, left.getIntrinsicWidth(), left.getIntrinsicHeight());
    }

    /**
     * 设置右边图片资源id
     * @param id
     */
    public void setRightIcon(int id) {
        right = getResources().getDrawable(id);
        right.setBounds(0, 0, right.getIntrinsicWidth(), right.getIntrinsicHeight());
    }

    /**
     * 隐藏左边图片,显示右边.
     */
    public void hideLDisplayR(){
        this.setCompoundDrawables(null,null, right, null);
    }

    /**
     * 显示左边图片,隐藏右边.
     */
    public void displayLHideR(){
        this.setCompoundDrawables(left, null, null, null);
    }

    /**
     * 隐藏所有图片.
     */
    public void hideAll(){
        this.setCompoundDrawables(null, null, null, null);
    }

    /**
     * 显示左右图片.
     */
    @Override
    public void displayAll(){
        this.setCompoundDrawables(left, null, right, null);
    }

}
