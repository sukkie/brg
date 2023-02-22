package com.example.demo.brg;

import com.example.demo.brg.hotel.AbstractHotel;
import com.example.demo.brg.hotel.HotelPlanner;
import com.example.demo.brg.hotel.Rehlat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelManager {

    List<AbstractHotel> hotelList = new ArrayList<>();

    public void init() {
        // 2,033,500
        // IDR Avg./night
        // + 1,708,140
        // IDR Taxes and fees
        // 9,842,140
        // 2023-07-23 ~ 2023-07-27 The Stones Legian Bali Marriott Autograph Collection Hotel
        hotelList.add(new HotelPlanner("HotelPlanner - The Stones Legian Bali",
            "https://www.hotelplanner.com/Common/Cfcs/services/rates/checkRates.htm?locale=en_US&currency=IDR&brandCode=AU&starRating=5.0&vendor=tp&hotelId=59153&aky=E505296245FD3EE1E7E090FED4CE5E9C&_dc=1676947856066&gid=0&checkin=07%2F23%2F2023&checkout=07%2F27%2F2023&numRooms=2&numAdults=2&numChildren=0&numAdults2=1&numChildren2=0&indate=07%2F23%2F2023&outdate=07%2F27%2F2023&page=1&start=0&limit=25&sort=%5B%7B%22property%22%3A%22AVERAGERATE%22%2C%22direction%22%3A%22ASC%22%7D%5D"));

        hotelList.add(new Rehlat("Rehlat - The Stones Legian Bali",
            "https://www.rehlat.com/Hotels/getHotelPricesThread", createParamData()));

        // 2,990,000
        // IDR Avg./night
        // + 2,511,600
        // IDR Taxes and fees
        // 14,471,600
        // IDR Subtotal
        // 2023-07-27 ~ 2023-07-31 The Westin Resort & Spa Ubud Bali Chse Certified
        hotelList.add(new HotelPlanner("HotelPlanner - The Westin Resort",
            "https://www.hotelplanner.com/Common/Cfcs/services/rates/checkRates.htm?locale=en_US&currency=IDR&brandCode=WE&starRating=5.0&vendor=tp&hotelId=F7535&aky=0BC9720E2B6887B7C43E09E4D45E0542&_dc=1676951070748&gid=0&checkin=07%2F27%2F2023&checkout=07%2F31%2F2023&numRooms=2&numAdults=2&numChildren=0&numAdults2=1&numChildren2=0&indate=07%2F27%2F2023&outdate=07%2F31%2F2023&page=1&start=0&limit=25&sort=%5B%7B%22property%22%3A%22AVERAGERATE%22%2C%22direction%22%3A%22ASC%22%7D%5D"));
    }

    public void run() {
        Thread t1 =new Thread(new BrgAutoSearch(hotelList));
        t1.start();
    }

    private Map<String, String> createParamData() {
        Map<String, String> data = new HashMap<>();
        data.put("Country","");
        data.put("CountryName","");
        data.put("CountryNameEn","");
        data.put("CountryNameArb","");
        data.put("City","");
        data.put("CityName","");
        data.put("CityNameArb","");
        data.put("CheckInDate","2023-07-23T00:00:00");
        data.put("CheckOutDate","2023-07-27T00:00:00");
        data.put("CiDate","20230723");
        data.put("CoDate","20230727");
        data.put("CinDate","23 Jul 2023");
        data.put("CoutDate","27 Jul 2023");
        data.put("NoOfNights","4");
        data.put("RoomCount","0");
        data.put("Rooms[0][Adults]","2");
        data.put("Rooms[0][Children]","0");
        data.put("Rooms[0][ChildrenAges]","");
        data.put("Rooms[0][TotalPax]","2");
        data.put("EchoToken","echo202302210501396633");
        data.put("SessionId","session202302210501396633");
        data.put("HotelCode","1017401");
        data.put("SupHotelCode","");
        data.put("HotelName","the stones legian bali marriott autograph collection hotel");
        data.put("HotelNameArb","");
        data.put("DestinationCode","");
        data.put("Currency","KWD");
        data.put("IsLocality","false");
        data.put("LocalityName","");
        data.put("Lang","en");
        data.put("HotelCodes","");
        data.put("SearchId","1017401");
        data.put("SourceType","Hotels");
        data.put("Adults","0");
        data.put("Children","0");
        data.put("EmailAddress","");
        data.put("RahlatUrl","");
        data.put("ImageUrl","");
        data.put("Anchor[Anchor1]","");
        data.put("Anchor[Anchor2]","");
        data.put("Anchor[Anchor3]","");
        data.put("Anchor[Anchor4]","");
        data.put("Anchor[Anchor5]","");
        data.put("Anchor[Anchor6]","");
        data.put("Anchor[Anchor7]","");
        data.put("Anchor[Anchor8]","");
        data.put("TotalNoOfHotelInCountry","");
        data.put("TotalNoOfHotelInCity","");
        data.put("TotalNoOfHotelInArea","");
        data.put("OneSTARHotel","0");
        data.put("TwoSTARHotel","0");
        data.put("ThreeSTARHotel","0");
        data.put("FourSTARHotel","0");
        data.put("FiveSTARHotel","0");
        data.put("VillaCount","0");
        data.put("ApartmentCount","0");
        data.put("PropertyCount","0");
        data.put("PaginationRequired","false");
        data.put("Key","");
        data.put("SessionKey","");
        data.put("UserTracking","");
        data.put("utm_source","");
        data.put("SupplierId","");
        data.put("SearchKey","");
        data.put("isSeo","false");
        data.put("sourceMarket","");
        data.put("MetaSearch","");
        data.put("ClientID","");
        data.put("CacheKey","");
        data.put("ClientCode","WEB");
        data.put("DomainName","COM");
        data.put("userEmail","");
        data.put("Identifier","");
        data.put("encrypted_payload","");
        data.put("wego_click_id","");
        data.put("AffiliateID","");
        data.put("Microsites","");
        data.put("skip","0");

        return data;
    }
}
