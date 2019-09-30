# Library

## 정의
* 특정 기능을 가지고 있는 외부 Class 또는 Function

## Library는 언제 사용 할까
* 안드로이드에서 기본적으로 제공해주지 않는 기능을 외부에서 가져와서 사용하고 싶을 때 사용한다.
* 안드로이드에서 기본적으로 제공해주지 않는 기능을 편하게 사용하고 싶을 떄 사용한다.

## Library를 사용하는 방법
* glide Libary: https://github.com/bumptech/glide

## Glide Libary Installation
* build.gradle(project level)을 다음과 같이 업데이트 한다. Sync를 꼭 하도록 한다.
```java
repositories {
        google()
        jcenter()
        mavenCentral() // 업데이트 된 부분
        maven { url 'https://maven.google.com' } // 업데이트 된 부분
    }
```
* build.gradle(app level)을 다음과 같이 업데이트 한다. Sync를 꼭 하도록 한다.
```java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'

    implementation 'com.github.bumptech.glide:glide:4.9.0' // 업데이트 된 부분
    // Skip this if you don't want to use integration libraries or configure Glide. // 업데이트 된 부분
    annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0' // 업데이트 된 부분
```
* AndroidManifest.xml 파일의 application tag 바로 위에 다음 코드를 삽입한다.
```xml
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```
* MainActivity.java 파일과 activity_main.xml 파일을 다음과 같이 업데이트 해서 사용한다.
MainActivity.java
```java
package com.example.libraryglideexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewOne;
    ImageView imageViewTwo;
    ImageView imageViewThree;
    ImageView imageViewFour;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        imageViewOne = findViewById(R.id.image_one);
        imageViewTwo = findViewById(R.id.image_two);
        imageViewThree = findViewById(R.id.image_three);
        imageViewFour = findViewById(R.id.image_four);
        //웹사이트 이미지 로딩 기초
        Glide.with(MainActivity.this)
                .load("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg")
                .into(imageViewOne);
        //센터 크롭하는 방법
        RequestOptions cropOption = new RequestOptions().centerCrop();
        Glide.with(context)
                .load("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg")
                .apply(cropOption)
                .into(imageViewTwo);
        //둥글게 크롭하는 방법
        RequestOptions circleCropOption = new RequestOptions().circleCrop();
        Glide.with(context)
                .load("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg")
                .apply(circleCropOption)
                .into(imageViewThree);
        //로컬 이미지 불러오는 방법
        Glide.with(context)
                .load(R.drawable.ic_launcher_background)
                .into(imageViewFour);

    }
}

```
activity_main.xml
```java
<?xml version="1.0" encoding="utf-8"?>
<ScrollView android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/image_one"
        android:layout_width="200dp"
        android:layout_height="200dp" />

    <ImageView
        android:id="@+id/image_two"
        android:layout_width="200dp"
        android:layout_height="200dp" />

    <ImageView
        android:id="@+id/image_three"
        android:layout_width="200dp"
        android:layout_height="200dp" />

    <ImageView
        android:id="@+id/image_four"
        android:layout_width="200dp"
        android:layout_height="200dp" />

</LinearLayout>
</ScrollView>
```