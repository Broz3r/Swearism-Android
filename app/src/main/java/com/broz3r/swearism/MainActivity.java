package com.broz3r.swearism;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.swear_view)
    protected SwearView swearView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onButtonClicked() {
        if (swearView.getSide() == SwearView.Side.LEFT) {
            swearView.setSide(SwearView.Side.RIGHT);
        }
        else {
            swearView.setSide(SwearView.Side.LEFT);
        }
    }
}
