package com.example.expensy.Fragments.analytics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.expensy.R;

public class AnalyticsFragment extends Fragment {

    private AnalyticsViewModel analyticsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        analyticsViewModel =
                new ViewModelProvider(this).get(AnalyticsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_analytics, container, false);
        final TextView textView = root.findViewById(R.id.text_analytics);
        analyticsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}