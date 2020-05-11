package com.androidcontrol.editText;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.androidcontrol.R;

/**
 * Created by zy on 2018/7/12.
 */

public class ClearEditText extends LeftRightEditText implements TextWatcher {

    private Context context;

    private TextWatcher textWatcher;

    public ClearEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs,context);
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,context);
    }

    public ClearEditText(Context context) {
        super(context);
        init(null,context);
    }

    private void init(AttributeSet attrs,Context context) {
        this.context = context;
        if (right == null){
            setDeleteImage(R.drawable.nim_icon_edit_delete);
        }

        ClearEditText.this.addTextChangedListener(this);
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
     * 传入删除图标资源id
     *
     * @param id
     */
    public void setDeleteImage(int id) {
        setRightIcon(id);
        manageClearButton();
    }

    void manageClearButton() {
        if (this.getText().toString().equals(""))
            removeClearButton();
        else
            addClearButton();
    }

    void removeClearButton() {
        displayLHideR();
    }

    void addClearButton() {
        displayAll();
    }

    /**
     * 点击了右边
     */
    @Override
    public boolean onClickRight() {
        getText().clear();
        removeClearButton();
        return false;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        ClearEditText.this.manageClearButton();
        if ( textWatcher!= null){
            textWatcher.onTextChanged(s,start,before,count);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if ( textWatcher!= null){
            textWatcher.beforeTextChanged(s,start,count,after);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        if ( textWatcher!= null){
            textWatcher.afterTextChanged(s);
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.textWatcher = textWatcher;
    }
}
