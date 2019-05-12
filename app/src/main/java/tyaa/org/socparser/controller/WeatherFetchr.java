package tyaa.org.socparser.controller;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import tyaa.org.socparser.entity.CityItem;
import tyaa.org.socparser.entity.CityItemList;

/**
 * Created by student on 19.08.2017.
 */

public class WeatherFetchr {

    public static final String TAG = "WeatherFetchr";
    protected static final String WEATHER_URL = "https://www.meteoprog.ua/ru/catalog/Ukraine/";

    public CityItemList mCityItemList;

    //
    public CityItemList downloadCitiesItems(String regionName) throws IOException {


        if (mCityItemList == null){

            mCityItemList = new CityItemList();
        }

         //= "Donecka";
        try {
            //получаем результат запроса в виде строки
            //String htmlString = getUrl(url);
            //создаем объект-документ из всего результата запроса
            Document document = Jsoup.connect(WEATHER_URL).get();

            //Log.d("Result: ", document.title());
            //создаем объект-коллекцию элементов Jsoup
            Elements elementCitiesItems =
                    document.select("div.catalogCitiesBlock > a[name=" + regionName + "] ~ .mp-listCountry li > a");

            for (Element a : elementCitiesItems) {

                CityItem cityItem = new CityItem();
                cityItem.name = a.text();
                //Log.d("Result: ", a.text());
                mCityItemList.setCity_item(cityItem);
            }

        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch events items", ioe);
            throw ioe;
        }
        return mCityItemList;
    }
}
