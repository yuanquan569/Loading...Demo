package com.forever.loadingdemo;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] dotText = {" . ", " . . ", " . . ."};
    ValueAnimator valueAnimator;
    private TextView dotView;
    private String loadingTxt = "加载中";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotView = (TextView) findViewById(R.id.tv_dot);

        if (valueAnimator == null) {
            valueAnimator = ValueAnimator.ofInt(0, 3).setDuration(1000);
            valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int i = (int) animation.getAnimatedValue();
                    dotView.setText(loadingTxt + dotText[i % dotText.length]);
                }
            });
        }
        valueAnimator.start();

    }
}
