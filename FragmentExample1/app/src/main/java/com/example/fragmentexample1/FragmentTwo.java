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

public class FragmentTwo extends Fragment {
    @Override
    public void onAttach(Context context) {
        Log.d("LifeCycle","Fragment Two : onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("LifeCycle","Fragment Two : onCreate");
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("LifeCycle","Fragment Two : onCreateView");
        return inflater.inflate(R.layout.fragment_two, container,false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("LifeCycle","Fragment Two : onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("LifeCycle","Fragment Two : onStart");
        super.onStart();
    }

    @Override
    public void onPause() {
        Log.d("LifeCycle","Fragment Two : onPause");
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        Log.d("LifeCycle","Fragment Two : onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("LifeCycle","Fragment Two : onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("LifeCycle","Fragment Two : onDetach");
        super.onDetach();
    }
}
