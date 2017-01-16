package com.broz3r.swearism;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.swear_view)
    protected SwearView swearView;

    private SwearManager swearManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        swearManager = new SwearManager(this, swearView);
        swearManager.changeSwear();
    }

    @OnClick(R.id.button)
    public void onButtonClicked() {
        swearManager.changeSwear();
    }
}
