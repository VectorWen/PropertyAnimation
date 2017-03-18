package com.vector.propertyanimation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * author: vector.huang
 * date: 2017/03/18 18:19
 */
public class BaseAnimationActivity extends AppCompatActivity {

    private Button mButton0;
    private ImageView mImageView0;
    private ImageView mImageView1;
    private ImageView mImageView3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_animation_activity);
        mButton0 = (Button) findViewById(R.id.button0);
        mImageView0 = (ImageView) findViewById(R.id.image0);
        mImageView1 = (ImageView) findViewById(R.id.image1);
        mImageView3 = (ImageView) findViewById(R.id.image3);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                final int size = mImageView1.getMeasuredHeight();
                ValueAnimator animator = ValueAnimator.ofInt(0, mImageView1.getMeasuredHeight()).setDuration(200);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Integer integer = (Integer) animation.getAnimatedValue();
                        mImageView0.getLayoutParams().height = integer;
                        mImageView0.getLayoutParams().width = integer;
                        mImageView0.requestLayout();

                        mImageView3.getLayoutParams().height = size - integer;
                        mImageView3.getLayoutParams().width = size - integer;
                        mImageView3.requestLayout();
                    }
                });
                mImageView0.setVisibility(View.VISIBLE);
                animator.start();
                break;
        }
    }
}
