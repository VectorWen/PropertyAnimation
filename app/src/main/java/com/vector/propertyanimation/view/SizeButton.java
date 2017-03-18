package com.vector.propertyanimation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * author: vector.huang
 * date: 2017/03/18 18:32
 */
public class SizeButton extends Button {

    private int layoutHeightBy = 0;
    private int layoutWidthBy = 0;
    private int height = 0;
    private int width = 0;
    private boolean updateBy;

    public int getLayoutHeightBy() {
        return layoutHeightBy;
    }

    public void setLayoutHeightBy(int layoutHeightBy) {
        this.layoutHeightBy = layoutHeightBy;
        updateBy();

    }

    public int getLayoutWidthBy() {
        return layoutWidthBy;
    }

    public void setLayoutWidthBy(int layoutWidthBy) {
        this.layoutWidthBy = layoutWidthBy;
        updateBy();
    }

    private void updateBy() {
        if(!updateBy){
            width = getMeasuredWidth();
            height = getMeasuredHeight();
            updateBy = true;
        }
        getLayoutParams().width = width + layoutWidthBy;
        getLayoutParams().height = height + layoutHeightBy;
        requestLayout();
    }

    public SizeButton(Context context) {
        super(context);
    }

    public SizeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SizeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
