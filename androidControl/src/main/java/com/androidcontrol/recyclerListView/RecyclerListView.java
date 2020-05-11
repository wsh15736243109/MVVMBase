package com.androidcontrol.recyclerListView;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zy on 2018/8/1.
 */
public class RecyclerListView extends RecyclerView {

    public RecyclerListView(Context context) {
        this(context,null);
    }

    public RecyclerListView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public RecyclerListView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


}
