package com.example.demo.brg.hotel;

import com.example.demo.DemoApplication;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * https://www.rehlat.com/en/cheap-hotels.
 */
public class Rehlat extends AbstractHotel {

    private Map<String, String> data;

    private String initUrl = "https://www.rehlat.com/en/cheap-hotels/searchresults?aid=the-stones-legian-bali-marriott-autograph-collection-hotel-1017401";

    private String sessionId;

    public Rehlat(String hotelName, String endPoint, Map<String, String> data) {
        super.hotelName = hotelName;
        super.endPoint = endPoint;
        this.data = data;
        this.sessionId = getSessionId();
        init();
    }

    public String getSessionId() {
        Connection con = Jsoup.connect(initUrl).timeout(10000);
        Response res = null;
        try {
            res = con.method(Connection.Method.GET).ignoreContentType(true).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res.cookie("ASP.NET_SessionId");
    }

    @Override
    public void init() {
        currentCurrency = getRoomRate();
        System.out.println("init : " + hotelName + " , " + currentCurrency);
    }

    @Override
    public void run() {
        loop++;
        double roomRate = getRoomRate();
        System.out.println(hotelName + " , " + loop + " , " + roomRate);
        // 새로운 방값이 더 저렴하면
        if (roomRate < currentCurrency) {
            super.currentCurrency = roomRate;
            sendMessage("HotelPlanner", Double.toString(roomRate), this.endPoint);
        }
        DemoApplication.RESULT_SET.put(hotelName, loop + " , " + currentCurrency);
    }

    public double getRoomRate() {
        Connection con = Jsoup.connect(endPoint).timeout(10000);
        con.cookie("ASP.NET_SessionId", sessionId);

        con.data(data);

        Connection.Response res = null;
        try {
            res = con.method(Connection.Method.POST).ignoreContentType(true).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(res.body(), Map.class);
        List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("Hotels");

        return (double) list.get(0).get("base_amount");
    }
}
