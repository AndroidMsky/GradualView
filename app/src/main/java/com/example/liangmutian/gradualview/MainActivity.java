package com.example.liangmutian.gradualview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.liangmutian.graduallibrary.GradualImageView;
import com.example.liangmutian.graduallibrary.GradualTextView;


public class MainActivity extends AppCompatActivity {
    GradualTextView mGradualView;
    GradualImageView mGradualView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGradualView2=(GradualImageView)findViewById(R.id.gv2);
        mGradualView=(GradualTextView)findViewById(R.id.gv1);
        mGradualView.setTextColor(Color.YELLOW,Color.RED);
        mGradualView.setText("Good Good");
        mGradualView2.setImgResourse(R.mipmap.q1,R.mipmap.q2);


    }
    public void start(View v){

        mGradualView.startChange(1000);


    }
    public void backstart(View v){

        mGradualView.backChange(1000);


    }


    public void startimg(View v){

        mGradualView2.startChange(1000);


    }
    public void backstartimg(View v){

        mGradualView2.backChange(1000);


    }

}
