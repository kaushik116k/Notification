package com.example.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<String> {
    String[] names;
    int[] images;
    Context mContext;
    public MyAdapter(@NonNull Context context, String[] transport, int[] symbols) {
        super(context, R.layout.single_row);
        this.names = transport;
        this.images = symbols;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.single_row, parent, false);
            mViewHolder.mTrans = convertView.findViewById(R.id.imageView);
            mViewHolder.mText = convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        }
        else
        {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mTrans.setImageResource(images[position]);
        mViewHolder.mText.setText(names[position]);
        return convertView;
    }
    static class ViewHolder
    {
        ImageView mTrans;
        TextView mText;

    }
}
