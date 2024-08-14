package com.example.rxjavapractice.examples.example4;

import android.os.SystemClock;

import java.util.concurrent.Callable;

public class CallableData {
    Callable<String> callable = () -> {
        SystemClock.sleep(2000);
        return "Hello";
    };
}
