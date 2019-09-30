package com.example.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SharedPreference에 데이터 저장하는 방법
        String sharedPreferenceName = "SAVE_1";
        String sharedPreferenceKey = "KEY";
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPreferenceName, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(sharedPreferenceKey, "안녕하세요");
        editor.putString("sharedPreferenceKey2", "안녕하세요2");
        editor.commit();

        // SharedPreference에 데이터 불러오는 방법
        String value = sharedPreferences.getString(sharedPreferenceKey,"실패");
        String value2 = sharedPreferences.getString("sharedPreferenceKey2","실패");
        Log.d("test","value1 : "+value+"value2 :"+value2);

        // SharedPreference에 데이터 삭제하는 방법
        editor.remove(sharedPreferenceKey);
        editor.clear(); // 전부다 삭제한다.
        editor.commit();

        // SharedPreference에 데이터 불러오는 방법
        String value1 = sharedPreferences.getString("sharedPreferenceKey2","실패");
        Log.d("test","value 2"+value1);

        // GSON을 사용하는 방법
        Person person = new Person("홍길동", 20);
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        Log.d("testt","value : " + personJson);

        String sharedPreferencePersonKey = "person_key";
        editor.putString(sharedPreferencePersonKey, personJson);
        editor.commit();

        String personString = sharedPreferences.getString(sharedPreferencePersonKey,"실패2");
        Person loadedPerson = gson.fromJson(personString, Person.class);

        Log.d("testt","person age : " + loadedPerson.age);

    }
}
