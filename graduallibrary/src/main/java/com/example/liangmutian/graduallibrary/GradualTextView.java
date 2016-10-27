package com.example.liangmutian.graduallibrary;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by msky air on 16/10/27.
 */

public class GradualTextView extends FrameLayout {
    private Context mContext;
    private TextView textView1;
    private TextView textView2;
    private int TextColor1 = Color.BLACK;
    private int TextColor2 = Color.BLUE;
    private String text = "";
    private boolean Start=true;

    public GradualTextView(Context context) {
        super(context);
        initView(context);
    }

    public GradualTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public GradualTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /*
    * color1 --->color2  please use deep color to color2
    * */
    public void setTextColor(int color1, int color2) {
        TextColor1 = color1;
        TextColor2 = color2;
        reset();
    }
    public void setText(String text) {
        this.text=text;
        reset();
    }

    private void reset() {
        textView1.setTextColor(TextColor1);
        textView2.setTextColor(TextColor2);
        textView2.setText(text);
        textView1.setText(text);
    }
    public void startChange(final int TIME){
        ObjectAnimator mObObjectAnimator=new ObjectAnimator();
        mObObjectAnimator.ofFloat(textView2, "Alpha", 1.0F,0.0F).setDuration(TIME).start();
        mObObjectAnimator.cancel();


    }
    public void backChange(final int TIME){

        ObjectAnimator mObObjectAnimator=new ObjectAnimator();
        mObObjectAnimator.ofFloat(textView2, "Alpha", 0.0F,1.0F).setDuration(TIME).start();
        mObObjectAnimator.cancel();


    }

    private void initView(Context context) {
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.main, this);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
    }


}
