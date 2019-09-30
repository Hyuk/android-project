package com.example.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);

        list = new ArrayList<>();
        list.add("가");
        list.add("나");
        list.add("다");
        list.add("라");
        list.add("마");
        list.add("바");
        list.add("사");
        list.add("아");
        list.add("자");
        list.add("차");
        list.add("카");
        list.add("타");
        list.add("파");
        list.add("하");
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");
        list.add("J");
        list.add("K");
        list.add("L");
        list.add("M");

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View header = layoutInflater.inflate(R.layout.header_view, null, false);
        View footer = layoutInflater.inflate(R.layout.footer_view, null, false);

        listView.addHeaderView(header);
        listView.addFooterView(footer);


        final MyAdapter myAdapter = new MyAdapter(MainActivity.this, list);
        listView.setAdapter(myAdapter);


        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.set(1, "가");
                Log.d("list_change", "list : " + list);
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    class MyAdapter extends BaseAdapter {

        private ViewHolder viewHolder;
        private LayoutInflater inflater;
        private ArrayList<String> itemList;

        public MyAdapter(Context context, ArrayList<String> itemList) {
            this.itemList = itemList;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public String getItem(int position) {
            return itemList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                Log.d("testt", "new");
                viewHolder = new ViewHolder();
                view = inflater.inflate(R.layout.list_item_view, null);
                viewHolder.textView = view.findViewById(R.id.item_view_text);
                view.setTag(viewHolder);
            } else {
                Log.d("testt", "recycle");
                viewHolder = (ViewHolder) view.getTag();
            }

            viewHolder.textView.setText(getItem(position));

            return view;
        }


        class ViewHolder {
            public TextView textView = null;
        }
    }
}
