package com.droidupps.myapplication.Ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.SharedElementCallback;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidupps.myapplication.Adapters.FragmentStartAdapter;
import com.droidupps.myapplication.Global.App;
import com.droidupps.myapplication.R;
import com.droidupps.myapplication.interfaces.IStartAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shahar ben hayun on 09/01/16.
 */
public class FragementStart extends Fragment implements IStartAdapter {

    private boolean mIsBack = false;
    private RecyclerView mRecyclerView;
    private SharedElementCallback ISharedElementCallback = new SharedElementCallback() {
        @Override
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {

            if (mIsBack) {
                View newSharedElement = mRecyclerView.getChildAt(App.instance.getPosition()).findViewById(R.id.imageView);
                names.clear();
                names.add(newSharedElement.getTransitionName());
                sharedElements.clear();
                sharedElements.put(newSharedElement.getTransitionName(), newSharedElement);
            }
            mIsBack = !mIsBack;
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setExitSharedElementCallback(ISharedElementCallback);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setAdapter(new FragmentStartAdapter(setRecyclerData(), this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }

    @Override
    public void onClick(View view, int position) {

        App.instance.setPosition(position);

        FragmentTwo fragmentTwo = new FragmentTwo(position);
        ChangeTransform changeTransform = new ChangeTransform();
        fragmentTwo.setSharedElementEnterTransition(new TransitionSet().setOrdering(TransitionSet.ORDERING_TOGETHER).addTransition(new ChangeBounds()).addTransition(changeTransform).setDuration(1000));
        fragmentTwo.setEnterTransition(new Slide());
        fragmentTwo.setSharedElementReturnTransition(new TransitionSet().setOrdering(TransitionSet.ORDERING_TOGETHER).addTransition(new ChangeBounds()).addTransition(changeTransform).setDuration(1000));
        fragmentTwo.setEnterTransition(new Slide());
        getActivity().getSupportFragmentManager().beginTransaction().addSharedElement(view, view.getTransitionName()).replace(R.id.container, fragmentTwo).addToBackStack(null).commit();
    }


    public List<String> setRecyclerData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            data.add("row number" + i);
        }
        return data;
    }
}
