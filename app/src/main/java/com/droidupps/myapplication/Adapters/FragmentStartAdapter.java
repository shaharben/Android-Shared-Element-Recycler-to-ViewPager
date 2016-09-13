package com.droidupps.myapplication.Adapters;

import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;


import com.droidupps.myapplication.R;
import com.droidupps.myapplication.interfaces.IStartAdapter;

import java.util.List;

/**
 * Created by shahar ben hayun on 09/01/16.
 */
public class FragmentStartAdapter extends RecyclerView.Adapter<FragmentStartAdapter.ViewHolder> {

    List<String> mData;
    IStartAdapter mIStartAdapter;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_fragment_start_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public FragmentStartAdapter(List<String> data, IStartAdapter iStartAdapter) {
        mData = data;
        mIStartAdapter = iStartAdapter;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mText.setText(mData.get(position));
        holder.mImage.setImageResource(R.mipmap.ic_launcher);
        ViewCompat.setTransitionName(holder.mImage, String.valueOf(position) + "_image");
        holder.mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIStartAdapter.onClick(holder.mImage, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mText;
        ImageView mImage;

        public ViewHolder(View view) {
            super(view);
            mText = (TextView) view.findViewById(R.id.textView);
            mImage = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
