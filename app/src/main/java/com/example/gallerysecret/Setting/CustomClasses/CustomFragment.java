package com.example.gallerysecret.Setting.CustomClasses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gallerysecret.Setting.mFragment;


public abstract class CustomFragment extends mFragment {
    public View parent ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parent = inflater.inflate(layout() , container,  false);
        onCreateMyView();
        return parent ;
    }
    public abstract int layout ();

    public abstract void onCreateMyView () ;
}
