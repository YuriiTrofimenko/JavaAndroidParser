package tyaa.org.socparser.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import tyaa.org.socparser.entity.CityItem;
import tyaa.org.socparser.entity.CityItemList;
import tyaa.org.socparser.entity.ICityItemList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by yurii on 22.08.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class WeatherFetchrTest {

    private CityItemList mCityItemList;
    private WeatherFetchr mWeatherFetchr;

    @Mock(name = "mCityItemList")
    private CityItemList mCityItemListMock;

    @Mock
    private CityItem mCityItemMock;

    @Mock
    private IWeatherFetchr mWeatherFetchrMock;

    @InjectMocks
    private WeatherFetchr mWeatherFetchrInjectMocks;

    ArgumentCaptor<CityItem> argument =
            ArgumentCaptor.forClass(CityItem.class);

    @Before
    public void setUp() throws Exception {

        mCityItemList = new CityItemList();
        mCityItemList.setCity_item(new CityItem());

        mWeatherFetchr = new WeatherFetchr();
        mWeatherFetchr.mCityItemList = mCityItemListMock;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void downloadCitiesItemsMock() throws Exception {

        doReturn(mCityItemList).when(mWeatherFetchrMock).downloadCitiesItems("Donecka");
        assertNotNull(mWeatherFetchrMock.downloadCitiesItems("Donecka"));
        assertNotNull(mWeatherFetchrMock.downloadCitiesItems("Donecka").mCityItemList);
        assertTrue(mWeatherFetchrMock.downloadCitiesItems("Donecka").mCityItemList.size() > 0);
        assertNull(mWeatherFetchrMock.downloadCitiesItems("asd"));

        //mWeatherFetchr.downloadCitiesItems("Donecka");
        //verify(mCityItemListMock, atLeast(1)).setCity_item(argument.capture());

        mWeatherFetchrInjectMocks.downloadCitiesItems("Donecka");
        verify(mCityItemListMock, atLeast(1)).setCity_item(argument.capture());
    }

    @Test
    public void downloadCitiesItems() throws Exception {

        assertNotNull(new WeatherFetchr().downloadCitiesItems("Donecka"));
        assertNotNull(new WeatherFetchr().downloadCitiesItems("Donecka").mCityItemList);
        assertTrue(new WeatherFetchr().downloadCitiesItems("Donecka").mCityItemList.size() > 0);

        assertNotNull(new WeatherFetchr().downloadCitiesItems("asd"));
        assertNotNull(new WeatherFetchr().downloadCitiesItems("asd").mCityItemList);
        assertTrue(new WeatherFetchr().downloadCitiesItems("asd").mCityItemList.size() == 0);
    }

}