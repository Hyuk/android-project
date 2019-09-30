package com.example.fragmentexample1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static com.example.fragmentexample1.MainActivity.BUNDLE_KEY;

public class FragmentOne extends Fragment {
    @Override
    public void onAttach(Context context) {
        Log.d("LifeCycle","Fragment One : onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("LifeCycle","Fragment One : onCreate");
        super.onCreate(savedInstanceState);
    }

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("LifeCycle","Fragment One : onCreateView");
        view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("LifeCycle","Fragment One : onActivityCreated");

        int number = getArguments().getInt(BUNDLE_KEY);
        Log.d("test","number = " + number);

        Button button = view.findViewById(R.id.fragment_one_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test","CLICK !");
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("LifeCycle","Fragment One : onStart");
        super.onStart();
    }

    @Override
    public void onPause() {
        Log.d("LifeCycle","Fragment One : onPause");
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        Log.d("LifeCycle","Fragment One : onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("LifeCycle","Fragment One : onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("LifeCycle","Fragment One : onDetach");
        super.onDetach();
    }
}
