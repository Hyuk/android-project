# Fragment
## 정의
* Activity 내에서 사용자 인터페이스의 일부를 나타낸다.
* 하나의 Activity에 Fragment를 조합하여 사용할 수 있다.
* Fragment 하나를 여러 Activity에서 사용할 수 있다.

## 제약사항
* Activity 내에 포함되어 있어야 한다.
* Activity의 수명 주기에 직접적으로 영향을 받는다.
* 모든 Fragment가 UI를 가지고 있어야 하는 것은 아니다.

## Life Cycle
* onAttach : Fragment가 Activity와 연관되어 있었던 경우 호출된다. (Activity가 전달된다.)
* onCreateView : Fragment가 자신의 사용자 인터페이스를 처음으로 그릴시간이 되면 호출된다.
* onActivityCreated : Activity의 onCreate()가 반환되면 호출된다.
* onDestroyView : Fragment와 연관된 뷰 계층이 제거되는 중일때 호출된다.
* onDetach : Fragment가 Activity와 연결이 끊어지는 중일때 호출된다.

## 관리방법
* Fragment는 FragmentManager로 관리한다.

## Reference: 
* https://developer.android.com/guide/components/fragments?hl=ko

## 생성방법(2개의 방법)
* Fragment를 특정 뷰(View 객체)에 할당한다.(XML에 등록하는 것보다 동적으로 사용할 수 있다. 예: Fragment에 버튼을 넣어 기능을 넣는 경우)
* Fragment를 xml에 등록한다.

### Fragment를 특정 뷰에 할당한다.
MainActivity.java
```java
package com.example.fragmentexample1;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LifeCycle", "Activity : onCreate");

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new FragmentOne()); // 작업
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

```
FragmentOne.java
```java
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("LifeCycle","Fragment One : onCreateView");
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("LifeCycle","Fragment One : onActivityCreated");
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

```
FragmentTwo.java
```java
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

```
activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">
    
    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="버튼"/>
    
    <LinearLayout
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:orientation="vertical"></LinearLayout>

</LinearLayout>
```
fragment_one.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary">

</LinearLayout>
```
fragment_two.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorAccent">

</LinearLayout>
```
### Fragment를 xml에 등록한다.
* activity_main.xml 파일에 다음과 같이 `<fragment>`를 추가한다. 그러면 프리뷰에 바로 등록이 된 것을 확인할 수 있다.
```java
<fragment
    android:id="@+id/fragment_one"
    android:name="com.example.fragmentexample1.FragmentTwo"
    android:layout_width="match_parent"
    android:layout_height="100dp" />
```

### Fragment에 버튼을 넣어 기능을 넣는 방법
* 위에 했던 것에 이어서 fragment_one.xml파일을 다음과 같이 업데이트 해서 버튼을 추가한다.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary">
    <Button
        android:id="@+id/fragment_one_button"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:text="버튼1"
        android:textSize="30dp"/>
</LinearLayout>
```
* FragmentOne.java파일을 다음과 같이 업데이트해서 기능을 추가할 수 있다. (onActivityCreated 부분 변경)
```java
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

    View view; // 이전에 onCreateView에서 사용했던 view를 전역변수로 사용해서 onActivityCreated에서 사용하기 위한 목적이다. 

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

```
### Activity에서 Fragment로 변수 전달하는 방법
* Activity에서 Activity로 변수 전달시에는 intent를 사용
* Activity에서 Fragment로 변수 전달시에서 bundle을 사용
* MainActivity.java 파일을 아래와 같이 업데이트 해서 Fragment에 변수를 전달한다.(`bundle.putInt("Bundle_Key", 10);`)
```java
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LifeCycle", "Activity : onCreate");

        Fragment fragmentOne = new FragmentOne();
        Bundle bundle = new Bundle();
        bundle.putInt("Bundle_Key", 10);
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

```
* FragmentOne.java파일을 아래와 같이 업데이트 해서 Activity에서 보낸 변수를 받는다.(`getArguments().getInt("Bundle_Key");`)
```java
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

        int number = getArguments().getInt("Bundle_Key");
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

```
* BUNDLE_KEY 값은 전역변수 선언해서 관리하기도 한다.
* 전체코드
* MainActivity.java
```java
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

```
* FragmentOne.java
```java
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
```
* FragmentTwo.java
```java
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
    
    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="버튼"/>
    
    <LinearLayout
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:orientation="vertical"></LinearLayout>

    <fragment
        android:id="@+id/fragment_one"
        android:name="com.example.fragmentexample1.FragmentTwo"
        android:layout_width="match_parent"
        android:layout_height="100dp" />
</LinearLayout>
```
* fragment_one.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary">
    <Button
        android:id="@+id/fragment_one_button"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:text="버튼1"
        android:textSize="30dp"/>
</LinearLayout>
```
* fragment_two.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorAccent">

</LinearLayout>
```

