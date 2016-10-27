package com.example.liangmutian.graduallibrary;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wuduogen838 on 16/10/27.
 */

public class GradualImageView extends FrameLayout {

    private Context mContext;
    private ImageView imageView1;
    private ImageView imageView2;
    private int ImgResourse1 = 0;
    private int ImgResourse2 = 0;



    public GradualImageView(Context context) {
        super(context);
        initView(context);

    }

    public GradualImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public GradualImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void setImgResourse(int ImgResourse1, int ImgResourse2) {
        this.ImgResourse1 = ImgResourse1;
        this.ImgResourse2 = ImgResourse2;
        reset();
    }
//    public void setText(String text) {
//        this.text=text;
//        reset();
//    }

    private void reset() {
        imageView2.setImageResource(ImgResourse1);
        imageView1.setImageResource(ImgResourse2);

    }
    public void startChange(final int TIME){
        ObjectAnimator mObObjectAnimator=new ObjectAnimator();
        mObObjectAnimator.ofFloat(imageView2, "Alpha", 1.0F,0.0F).setDuration(TIME).start();
        mObObjectAnimator.cancel();


    }
    public void backChange(final int TIME){

        ObjectAnimator mObObjectAnimator=new ObjectAnimator();
        mObObjectAnimator.ofFloat(imageView2, "Alpha", 0.0F,1.0F).setDuration(TIME).start();
        mObObjectAnimator.cancel();


    }

    private void initView(Context context) {
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.main_img, this);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
    }

}
