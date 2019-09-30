package com.example.fragmentexample1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Button button;

    public static final String BUNDLE_KEY = "bundle_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LifeCycle", "Activity : onCreate");

        Fragment fragmentOne = new FragmentOne();
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_KEY, 10);
        fragmentOne.setArguments(bundle);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragmentOne); // 작업
        fragmentTransaction.commit(); // 확인

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.container, new FragmentTwo());
                fragmentTransaction1.commit();
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d("LifeCycle", "Activity : onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("LifeCycle", "Activity : onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("LifeCycle", "Activity : onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d("LifeCycle", "Activity : onDestroy");
        super.onDestroy();
    }
}
