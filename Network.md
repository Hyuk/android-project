# Network

## Request
* GET: 데이터를 요청
* POST: 정보 제출
* PUT: 내용 갱신
* DELETE: 삭제
* Header: 인증 정보

## Response Code
* 200: Success
* 201: Created
* 404: Not found

## JSON
* 경량 data 교환 방식
* 사람과 기계 모두 이해 하기 쉽다.
* 특정 언어에 종속되지 않는다.
```json
{
    "Name":"홍길동",
    "age":20,
    "friends":["김철수","김아무개"]
}
```
* Example: https://jsonapi.org/examples

## Postman
* https://www.getpostman.com

## Retrofit
* http://devflow.github.io/retrofit-kr/
* Android network Library
* 동기, 비동기 모두 지원, 편한 사용성

## Retrofit 설치
* build.gradle app단위 파일을 다음과 같이 업데이트 한다.
```java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    implementation 'com.squareup.retrofit2:retrofit:2.5.0' // 업데이트 된 부분
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'  // 업데이트 된 부분
}
```
* AndroidManifest.xml 파일에 다음 구문을 `<application>`위에 추가한다.
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```
## Stetho 설치 & ## okhttp3 설치
* build.gradle app단위 파일에 다음 소스코드를 추가 업데이트 한다.
```java
implementation 'com.facebook.stetho:stetho:1.4.2'
implementation 'com.facebook.stetho:stetho-okhttp3:1.4.2'
```
## Chrome DevTools
chrome://inspect/#devices

* MainActivity.java
```java
package com.example.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.JsonObject;

import org.w3c.dom.Text;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // Stetho Debugging address
    // chrome://inspect/#device

    TextView textView1;
    TextView textView2;
    MyService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(MyService.class);

        textView1 = findViewById(R.id.text1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestUserRepo();
            }
        });

        textView2 = findViewById(R.id.text2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postUser();
            }
        });
    }

    public void postUser() {
        Call<JsonObject>postUser = service.postUser("username", 20);
        postUser.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    public void requestUserRepo() {
        Call<JsonObject> requestUserRepo = service.getUseRepositories("hyuk"); // 통신 한발 쏠 준비
        // https://api.github.com/users/hyuk/repos
        requestUserRepo.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}

```
* MyService.java
```java
package com.example.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyService {

    // https://api.github.com/
    @GET("users/{user}/repos")
    Call<JsonObject> getUseRepositories(@Path("user") String userName);

    @FormUrlEncoded
    @POST("users/repos")
    Call<JsonObject> postUser(@Field("username") String name, @Field("age") int age);
}

```
*activity_main.xml
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/text1"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:background="@color/colorAccent"/>

    <TextView
        android:id="@+id/text2"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:background="@color/colorPrimary"/>

</LinearLayout>
```