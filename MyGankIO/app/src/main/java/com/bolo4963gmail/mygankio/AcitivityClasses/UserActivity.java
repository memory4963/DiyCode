package com.bolo4963gmail.mygankio.AcitivityClasses;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bolo4963gmail.mygankio.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends BaseActivity {

    @BindView(R.id.user_toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setTitle("用户信息");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
