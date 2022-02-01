package com.training.spring.di;


public class MySingleton {

    private volatile static MySingleton instance;


    private MySingleton() {
    }

    public static MySingleton getInstance() {
        if (MySingleton.instance == null) {
            synchronized (MySingleton.class) {
                if (MySingleton.instance == null) {
                    MySingleton.instance = new MySingleton();
                }
            }
        }
        return MySingleton.instance;
    }


}
