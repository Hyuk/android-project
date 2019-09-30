# AddView(리스트뷰)

* Inflater : item을 해당 layout에 그리는 역할
* Item : 리스트 목록 하나 하나
* Item list : 리스트 목록
* Layout File : item 하나가 그려질 view

* MainActivity.java
```java
package com.example.addviewlistexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> stringList;
    LayoutInflater layoutInflater;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringList = new ArrayList<>();
        stringList.add("가");
        stringList.add("나");
        stringList.add("다");
        stringList.add("라");
        stringList.add("마");
        stringList.add("바");
        stringList.add("사");
        stringList.add("아");

        container = findViewById(R.id.container);

        layoutInflater = LayoutInflater.from(MainActivity.this);

        for(int i = 0; i < stringList.size(); i++) {
            View view = layoutInflater.inflate(R.layout.list_item_view, null,false);
            TextView itemText = view.findViewById(R.id.item_view_text);
            itemText.setText(stringList.get(i));
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test","CLICK !");
                }
            });
            container.addView(view);
        }
    }
}

```
* activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <LinearLayout
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"></LinearLayout>

</LinearLayout>
```
* list_item_view.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/item_view_text"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:gravity="center_vertical"
        android:textSize="20dp"
        android:textColor="@color/colorAccent"
        android:background="@color/colorPrimary"/>

</LinearLayout>
```