package tyaa.org.socparser.controller;

import tyaa.org.socparser.entity.CityItemList;

/**
 * Created by yurii on 23.08.17.
 */

public interface IWeatherFetchr {

    CityItemList downloadCitiesItems(String regionName);
}
