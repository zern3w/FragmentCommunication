package com.example.puttipong.testfragment;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fragment.FirstFragment;
import fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // First Created

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainerUpper, FirstFragment.newInstance(),
                            "FirstFragment")
                    .commit();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainerLower, SecondFragment.newInstance(),
                            "SecondFragment")
                    .commit();
        }


    }
}
