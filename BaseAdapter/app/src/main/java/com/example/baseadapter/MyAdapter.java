package com.example.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    Context context;
    String[] name;
    int[] images;
    LayoutInflater inflater;

    public MyAdapter(Context context, String[] name, int[] images) {
        this.context = context;
        this.name = name;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { return name.length; }

    @Override
    public Object getItem(int i) { return name[i]; }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.row_layout, null);

        ImageView img = view.findViewById(R.id.imgIcon);
        TextView text = view.findViewById(R.id.textName);

        img.setImageResource(images[position]);
        text.setText(name[position]);

        return view;
    }
}
