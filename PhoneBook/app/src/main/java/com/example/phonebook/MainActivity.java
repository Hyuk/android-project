package com.example.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PhoneBook> phoneBookList;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        PhoneBook phoneBook1 = new PhoneBook("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg","홍길동","010-1111-1111");
        PhoneBook phoneBook2 = new PhoneBook("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg","길동홍","010-1111-1112");
        PhoneBook phoneBook3 = new PhoneBook("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg","문재인","010-1111-1113");
        PhoneBook phoneBook4 = new PhoneBook("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg","김대중","010-1111-1114");
        PhoneBook phoneBook5 = new PhoneBook("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg","노무현","010-1111-1115");
        PhoneBook phoneBook6 = new PhoneBook("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg","이강인","010-1111-1116");
        PhoneBook phoneBook7 = new PhoneBook("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg","어머니","010-1111-1117");
        PhoneBook phoneBook8 = new PhoneBook("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg","아버지","010-1111-1118");
        PhoneBook phoneBook9 = new PhoneBook("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg","누나","010-1111-1119");
        PhoneBook phoneBook10 = new PhoneBook("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg","와이프","010-1111-1120");
        PhoneBook phoneBook11 = new PhoneBook("https://laftelimage.blob.core.windows.net/items/thumbs/large/5ec987a2-8705-444d-a6d9-ff151f4edc92.jpg","처제","010-1111-1121");


        phoneBookList = new ArrayList<>();
        phoneBookList.add(phoneBook1);
        phoneBookList.add(phoneBook2);
        phoneBookList.add(phoneBook3);
        phoneBookList.add(phoneBook4);
        phoneBookList.add(phoneBook5);
        phoneBookList.add(phoneBook6);
        phoneBookList.add(phoneBook7);
        phoneBookList.add(phoneBook8);
        phoneBookList.add(phoneBook9);
        phoneBookList.add(phoneBook10);
        phoneBookList.add(phoneBook11);

        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        for(int i = 0; i < phoneBookList.size(); i++) {
            View view = layoutInflater.inflate(R.layout.phone_book_item_view,null,false);
            TextView name = view.findViewById(R.id.name);
            TextView number = view.findViewById(R.id.number);
            ImageView imageView = view.findViewById(R.id.imageView);

            name.setText(phoneBookList.get(i).name);
            number.setText(phoneBookList.get(i).number);
            RequestOptions circleOption = new RequestOptions().circleCrop();
            Glide.with(MainActivity.this)
                    .load(phoneBookList.get(i).image)
                    .apply(circleOption)
                    .into(imageView);

            final int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test", "number : " + phoneBookList.get(finalI).number);
                }
            });

            container.addView(view);
        }
    }
}
