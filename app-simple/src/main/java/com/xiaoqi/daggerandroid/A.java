package com.xiaoqi.daggerandroid;

import android.util.Log;

import javax.inject.Inject;

public class A {

    @Inject
    public A(){

    }

    public void someThingA(){
        Log.e("DAGGER", "someThingA");
    }
}
