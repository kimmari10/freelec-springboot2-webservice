package com.js.book.springboot.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BotService {
    private final String ENTER = "\\n";

    //날씨정보
    public String getWeather(String cmd) {
        String result = cmd.replace("!", "");
        String place = cmd.replace("!", "").replace("날씨", "").trim();

        String nowTemp = "현재온도 : ";
        String upTemp = "최고온도 : ";
        String downTemp = "최저온도 : ";
        String moist = "습도 : ";
        String wind = "바람 : ";

        Document weatherDom = null;


        try {
            weatherDom = Jsoup.connect("https://m.search.naver.com/search.naver?query="+place+"날씨").get();
            //System.out.println(weatherDom.html());
            //temperature_text 현재온도
            //up_temperature 최고온도
            //down_temperature 최저온도

            nowTemp += weatherDom.select(".temperature_text").get(0).text().replace("현재 온도", "").trim();
            upTemp += weatherDom.select(".up_temperature").text();
            downTemp += weatherDom.select(".down_temperature").text();
            moist += weatherDom.select(".type_humidity .figure_result").text() + "%";
            wind += weatherDom.select(".type_wind .figure_result").text() + "㎧";

//            System.out.println(nowTemp);
//            System.out.println(upTemp);
//            System.out.println(downTemp);
//            System.out.println(moist);
//            System.out.println(wind);

            result += nowTemp + ENTER + upTemp + ENTER + downTemp + ENTER + moist + ENTER + wind;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    //
}