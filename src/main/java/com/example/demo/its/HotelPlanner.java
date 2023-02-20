package com.example.demo.its;

import com.example.demo.DemoApplication;
import com.google.gson.Gson;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class HotelPlanner extends HotelInterface {

    public HotelPlanner(String endPoint) {
        super.endPoint = endPoint;
    }

    @Override
    public void init() {
        currentCurrency = getRoomRate();
        System.out.println("init : " + currentCurrency);
    }

    @Override
    public void run() {
        loop++;
        double roomRate = getRoomRate();
        System.out.println(loop + " , " + roomRate);
        // 새로운 방값이 더 저렴하면
        if (roomRate < currentCurrency) {
            super.currentCurrency = roomRate;
            sendMessage("HotelPlanner", Double.toString(roomRate), this.endPoint);
        }
        DemoApplication.RESULT_SET.put("HotelPlanner", loop + " , " + currentCurrency);
    }

    public double getRoomRate() {
        Connection con = Jsoup.connect(endPoint).timeout(10000);
        Connection.Response res = null;
        try {
            res = con.method(Connection.Method.GET).ignoreContentType(true).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(res.body(), Map.class);
        List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("rates");

        return (double) list.get(0).get("AVERAGERATE");
    }
}
