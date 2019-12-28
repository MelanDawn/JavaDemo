package com.dawn.utils;

public interface Log {

    static void d(String TAG, String msg, Object object) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append(TAG).append(" ] ").append(msg);
        System.out.println(sb.substring(0) + object);
    }

    static void d(String TAG, Object object) {
        d(TAG, "", object);
    }

    static void d(String TAG, String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append(TAG).append(" ] ").append(msg);
        System.out.println(sb.substring(0));
    }
}