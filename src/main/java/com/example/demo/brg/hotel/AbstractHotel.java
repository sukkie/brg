package com.example.demo.brg.hotel;

import com.example.demo.message.LineRunnable;

public abstract class AbstractHotel {

    protected double currentCurrency;

    protected int loop;

    protected String endPoint;

    abstract void init();

    public abstract void run();

    abstract double getRoomRate();

    protected void sendMessage(String name, String roomRate, String url) {
        Runnable runnable = new LineRunnable(name, roomRate, url);
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public int getLoop() {
        return loop;
    }

}
