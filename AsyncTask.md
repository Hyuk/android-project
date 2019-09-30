# AsyncTask

* 안드로이드에서는 UI 쓰레드를 정지시켜 둘수 없기 때문에, Background 작업이 필요한 경우를 위해서 AsyncTask를 지원한다.

## 동기, 비동기

* 동기: 작업이 완료될 때까지 다음 작업을 실행하지 않는다.
* 비동기: 작업이 시작되면 다음 작업을 진행하고, 작업이 완료된 경우 다시 호출이 된다.

## AsyncTask 4가지
* onPreExcute
background 작업이 시작하기 전에 호출된다.
* doInBackground
background 작업 구간
* onProgressUpdate
doInBackground이 실행되는 도중에 호출이 된다.
* onPostExcute
doInBackground가 완료되면 호출이 된다.

* MainActivity.java
```java
package com.example.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("test","PRE !!");
        BackgroundTask backgroundTask = new BackgroundTask();
        backgroundTask.execute();
        Log.d("test","POST !!");

    }

    class BackgroundTask extends AsyncTask<Integer,Integer,Integer> {
        @Override
        protected void onPreExecute() {
            Log.d("test","onPreExecute");
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int result = 0;
            for (int i = 0; i<100; i++) {
                result++;
                if (i%10 == 0) {
                    publishProgress(i);
                }
            }

            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.d("test","Progress : " + values[0] + "%");
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            Log.d("test","Result : " + integer);
            super.onPostExecute(integer);
        }

    }

}

```