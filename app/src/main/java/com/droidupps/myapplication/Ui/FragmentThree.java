package com.droidupps.myapplication.Ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.droidupps.myapplication.R;


/**
 * Created by shahar ben hayun on 09/01/16.
 */
@SuppressLint("ValidFragment")
public class FragmentThree extends Fragment {

    private ImageView mImage;
    private int mImageNum;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ValidFragment")
    public FragmentThree(int imageNum) {
        mImageNum = imageNum;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        mImage = (ImageView) view.findViewById(R.id.imageView);
        ViewCompat.setTransitionName(mImage, String.valueOf(mImageNum) + "_image");
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
