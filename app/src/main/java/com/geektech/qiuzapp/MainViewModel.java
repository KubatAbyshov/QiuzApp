package com.geektech.qiuzapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private int mCounter = 0;

    ArrayList<String> list = new ArrayList<>();
    public MutableLiveData<Integer> counter = new MutableLiveData<>();
    public MutableLiveData<ArrayList> history = new MutableLiveData<>();

    void onIncrementClick() {
        mCounter++;
        list.add("+");
        counter.setValue(mCounter);
        history.setValue(list);
    }

    void onDecrementClick() {
        mCounter--;
        list.add("-");
        counter.setValue(mCounter);
        history.setValue(list);
    }
}
