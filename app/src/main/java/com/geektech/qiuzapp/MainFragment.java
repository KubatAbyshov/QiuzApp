package com.geektech.qiuzapp;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private TextView tvText;
    private Button btnIncrement, btnDecrement;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = ViewModelProviders
                .of(getActivity())
                .get(MainViewModel.class);

        tvText = view.findViewById(R.id.counter);
        btnIncrement = view.findViewById(R.id.btn_increment);
        btnDecrement = view.findViewById(R.id.btn_decrement);

        int pos = getArguments().getInt("pos");
        switch (pos) {
            case 0:
                tvText.setVisibility(View.GONE);
                break;
            case 1:
                mViewModel.counter.observe(getActivity(), new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        tvText.setText(integer.toString());
                    }
                });

                btnIncrement.setVisibility(View.GONE);
                btnDecrement.setVisibility(View.GONE);
                break;

            case 2:
                mViewModel.history.observe(getActivity(), new Observer<ArrayList>() {
                    @Override
                    public void onChanged(ArrayList arrayList) {
                        tvText.setText(arrayList.toString());
                    }
                });

                btnIncrement.setVisibility(View.GONE);
                btnDecrement.setVisibility(View.GONE);
                break;
        }

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.onIncrementClick();
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.onDecrementClick();
            }
        });
    }
}
