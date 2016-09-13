package com.droidupps.myapplication.Ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.droidupps.myapplication.Adapters.MyFragmentPagerAdapter;
import com.droidupps.myapplication.Global.App;
import com.droidupps.myapplication.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shahar ben hayun on 09/01/16.
 */
@SuppressLint("ValidFragment")
public class FragmentTwo extends Fragment {

    private MyFragmentPagerAdapter mMyFragmentPagerAdapter;
    private ViewPager mPager;
    private ArrayList<Fragment> mFragments;
    private int mImageNum;
    private boolean mIsBack = false;
    private SharedElementCallback ISharedElementCallback = new SharedElementCallback() {
        @Override
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {

            if (mIsBack) {

                FragmentThree newSharedElement = (FragmentThree) mFragments.get(App.instance.getPosition());
                names.clear();
                sharedElements.clear();

                if (newSharedElement != null) {

                    View view = newSharedElement.getView().findViewById(R.id.imageView);
                    names.add(view.getTransitionName());
                    sharedElements.put(view.getTransitionName(), view);
                }
            }
            mIsBack = !mIsBack;
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterSharedElementCallback(ISharedElementCallback);
    }


    @SuppressLint("ValidFragment")
    public FragmentTwo(int imageNum) {
        mImageNum = imageNum;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mMyFragmentPagerAdapter = new MyFragmentPagerAdapter(getActivity().getSupportFragmentManager(), getData(), (AppCompatActivity) getActivity());
        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(mMyFragmentPagerAdapter);
        mPager.setCurrentItem(mImageNum);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                App.instance.setPosition(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private ArrayList<Fragment> getData() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mFragments.add(new FragmentThree(i));
        }
        return mFragments;
    }

}
