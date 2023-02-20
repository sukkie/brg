package com.example.demo.its;

public abstract class HotelInterface {

    double currentCurrency;

    int loop;

    String endPoint;

    abstract void init();

    abstract void run();

    protected void sendMessage(String name, String roomRate, String url) {
        Runnable runnable = new LineRunnable(name, roomRate, url);
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public int getLoop() {
        return loop;
    }

}
