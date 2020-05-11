package com.androidcontrol.editText;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;

import com.androidcontrol.R;

/**
 * Created by zy on 2018/7/16.
 */

public class IconEditText extends AppCompatEditText implements View.OnTouchListener{

    public Drawable right = null;

    public Drawable left = null;

    public Drawable top = null;

    public Drawable bottom = null;

    public Context context;

    public IconEditText(Context context) {
        super(context);
        init(null,context);
    }

    public IconEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,context);
    }

    public IconEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs,context);
    }

    private void init(AttributeSet attrs, final Context context) {
        this.context = context;
        TypedArray typedArray = null;
        if(attrs != null){
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconEditText);
        }
        left = optDraw(typedArray,R.styleable.IconEditText_left_icon,left);
        if(left != null){
            left.setBounds(0, 0, left.getIntrinsicWidth(), left.getIntrinsicHeight());
        }

        right = optDraw(typedArray,R.styleable.IconEditText_right_icon,right);
        if(right != null){
            right.setBounds(0, 0, right.getIntrinsicWidth(), right.getIntrinsicHeight());
        }

        top = optDraw(typedArray,R.styleable.IconEditText_top_icon,top);
        if(top != null){
            top.setBounds(0, 0, top.getIntrinsicWidth(), top.getIntrinsicHeight());
        }

        bottom = optDraw(typedArray,R.styleable.IconEditText_bottom_icon,bottom);
        if(bottom != null){
            bottom.setBounds(0, 0, bottom.getIntrinsicWidth(), bottom.getIntrinsicHeight());
        }

        setOnTouchListener(this);

        displayAll();
    }

    /**
     * 显示左右图片.
     */
    public void displayAll(){
        this.setCompoundDrawables(left, top, right, bottom);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_UP){
            return false;
        }
        if (right != null){
            if((event.getX() > getWidth() - getPaddingRight() - right.getIntrinsicWidth())){
                return  onClickRight();
            }
        }
        if (left != null){
            if((event.getX() < getPaddingRight() + left.getIntrinsicWidth())){
                return onClickLeft();
            }
        }

        if (top != null){
            if((event.getY() < getPaddingTop() + left.getIntrinsicHeight())){
                return onClickTop();
            }
        }

        if (bottom != null){
            if((event.getY() > getHeight()-getPaddingBottom() - left.getIntrinsicHeight())){
                return onClickBottom();
            }
        }
        return false;
    }

    /**
     * 点击了左边
     */
    public boolean onClickLeft(){
        return true;
    }

    /**
     * 点击了右边
     */
    public boolean onClickRight(){
        return true;
    }

    /**
     * 点击了上边
     */
    public boolean onClickTop(){
        return true;
    }

    /**
     * 点击了下边
     */
    public boolean onClickBottom(){
        return true;
    }

    public Drawable optDraw(TypedArray typedArray,int index,Drawable def) {
        if(typedArray == null){
            return def;
        }
        Drawable drawable = typedArray.getDrawable(index);
        if (drawable == null){
            return def;
        }
        return drawable;
    }

}
