# SharedPreference
* 간단한 데이터를 저장 하기에 용이하다.
* 보통 초기 설정값등을 저장 하는데 사용한다.
* data/data/PakageName/shared_prefs/이름 경로에 저장이 된다.
* Boolean, Integer, Float, Long, String을 저장할 수 있다.
* GSON을 사용하면 객체도 저장 가능하다.

* MODE_PRIVATE: 해당 app 내에서만 사용할 수 있다.
* MODE_WORLD_READABLE: 다른 app에서 읽기가 가능하다.
* MODE_WORLD_WRITABLE: 다른 app에서 쓰기가 가능하다.

* MainActivity.java
```java
package com.example.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
    }
}

```

## GSON을 사용하기 위해 build.gradle app단위에 추가하는 방법
* Android Studio에서 Search Icon을 클릭한 후, Project Structure을 검색한다.
* 좌측에서 Dependencies를 클릭한 후, app 단위에서 + 버튼을 클릭한다.
* Libarary Decpendencies를 클릭한 후 gson을 검색한 후 com.google.code.gson을 추가한다.
* 또는
* build.gradle app단위로 들어가 파일을 아래와 같이 수정한다.
```java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    implementation 'com.google.code.gson:gson:2.8.5' // 업데이트 된 부분
}
```

* MainActivity.java
```java
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

        // GSON을 사용하는 방법 - json 객체를 만든다.
        Person person = new Person("홍길동", 20);
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        Log.d("testt","value : " + personJson);
        // SharedPreference에 데이터를 저장한다.
        String sharedPreferencePersonKey = "person_key";
        editor.putString(sharedPreferencePersonKey, personJson);
        editor.commit();
        // SharedPreference에 저장된 데이터를 다시 불러온다.
        String personString = sharedPreferences.getString(sharedPreferencePersonKey,"실패2");
        Person loadedPerson = gson.fromJson(personString, Person.class);

        Log.d("testt","person age : " + loadedPerson.age);

    }
}

```
* Person.java
```java
package com.example.sharedpreference;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

```
