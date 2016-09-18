package com.mph.hhemptyview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mph.hhemptyview.widget.HHEmptyView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements HHEmptyView.OnBtnClickListener {

    private HHEmptyView emptyView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emptyView = (HHEmptyView) findViewById(R.id.hh_empty_view);
        textView = (TextView) findViewById(R.id.name);

        emptyView.bindView(textView);
        View view = getLayoutInflater().inflate(R.layout.loading_view, null);
        emptyView.setCustomLoadingView(view);
        emptyView.setOnBtnClickListener(this);
        loadData();
    }

    @Override
    public void onBtnClick() {
        loadData();
    }

    private void loadData() {
        emptyView.loading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Random r = new Random();
                int i = r.nextInt(5);
                if(i<=3){
                    emptyView.empty("网络连接失败");
                }else{
                    emptyView.success();
                }
            }
        },2000);
    }
}
