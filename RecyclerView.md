# Recycler View
* ListView의 업그레이드 버전

## 장점
* LayoutManger를 통해서 다양한 리스트 뷰를 만들 수 있다.
* ListView보다 효율적이다.

## 단점
* Header와 Footer를 위한 메소드가 없다.

## 사용하기 위한 셋업
* Recycler View를 사용하기 위해서는 build.gradle (app 이하)) 를 아래와 같이 업데이트 한다.
```java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'

    implementation 'com.android.support:recyclerview-v7.28.0.0' // 업데이트 된 부분
}
```

* MainActivity.java
```java
package com.example.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        itemList = new ArrayList<>();
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");
        itemList.add("가");

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this); // LinearLayout 세로형
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false); // LinearLayout 가로형
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3); // GridLayout 세로형
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3, LinearLayoutManager.HORIZONTAL, false); // GridLayout 가로형
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyAdapter(itemList));
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        private ArrayList<String> itemList;

        public MyAdapter(ArrayList<String> itemList) {
            this.itemList = itemList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_view, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            viewHolder.textView.setText(itemList.get(position));
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.item_text);
            }
        }
    }
}

```
* activity_main_xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
```
* item_view.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="100dp"
    android:layout_height="wrap_content"
    android:background="@color/colorPrimary"
    android:orientation="vertical">

    <TextView
        android:id="@+id/item_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="50dp" />

</LinearLayout>
```