package com.androidcontrol.editText;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;

import com.androidcontrol.R;

/**
 * Created by zy on 2018/7/12.
 */

public class PassHideEditText extends LeftRightEditText{

    int closeOpen = 0;

    private Context context;

    int inputType = 0;

    Drawable openEyes = null;
    Drawable closeEyes = null;

    public PassHideEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs,context);
    }

    public PassHideEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,context);
    }

    public PassHideEditText(Context context) {
        super(context);
        init(null,context);
    }

    private void init(AttributeSet attrs,Context context) {
        this.context = context;
        TypedArray typedArray = null;
        if(attrs != null){
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.PassHideEditText);
        }

        right = optDraw(typedArray,R.styleable.PassHideEditText_eyes_image_close, right);
        if (right == null){
            setRightIcon(R.drawable.user_eye_close);
            closeEyes = right;
            closeEyes.setBounds(0, 0, closeEyes.getIntrinsicWidth(), closeEyes.getIntrinsicHeight());
        }

        openEyes = optDraw(typedArray,R.styleable.PassHideEditText_eyes_image_close, openEyes);
        if (openEyes == null){
            openEyes = getResources().getDrawable(R.drawable.user_eye_open);
            openEyes.setBounds(0, 0, openEyes.getIntrinsicWidth(), openEyes.getIntrinsicHeight());
        }

        inputType = getInputType();
        manageClearButton();
    }

    /**
     * 传入显示的图标资源id
     *
     * @param id
     */
    public void setIconResource(int id) {
        setLefIcon(id);
        manageClearButton();
    }

    /**
     * 传入闭眼图标资源id
     *
     * @param id
     */
    public void setEyesCloseImage(int id) {
        setRightIcon(id);
        closeEyes = right;
        manageClearButton();
    }

    /**
     * 传入睁眼图标资源id
     *
     * @param id
     */
    public void setEyesOpenImage(int id) {
        openEyes = getResources().getDrawable(id);
        openEyes.setBounds(0, 0, openEyes.getIntrinsicWidth(), openEyes.getIntrinsicHeight());
        manageClearButton();
    }

    void manageClearButton() {
        if (closeOpen ==0 || closeOpen == 2){
            addCloseButton();
        }else {
            addOpenButton();
        }
    }

    void addCloseButton() {
        closeOpen = 1;
        setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.setCompoundDrawables(left, this.getCompoundDrawables()[1], closeEyes,
                this.getCompoundDrawables()[3]);
    }

    void addOpenButton() {
        closeOpen = 2;
        setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        this.setCompoundDrawables(left, this.getCompoundDrawables()[1], openEyes,
                this.getCompoundDrawables()[3]);
    }

    /**
     * 点击了右边
     */
    @Override
    public boolean onClickRight() {
        if(closeOpen==1){
            addOpenButton();
        }else if (closeOpen==2){
            addCloseButton();
        }
        return false;
    }

}
