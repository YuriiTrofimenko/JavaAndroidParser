package tyaa.org.socparser.controller;

import android.app.Activity;
import android.os.AsyncTask;

import java.io.IOException;

import tyaa.org.socparser.entity.CityItemList;
import tyaa.org.socparser.global.Globals;

/**
 * Created by student on 19.08.2017.
 */

public class FetchCitiesItemsTask extends AsyncTask<Object, Object, Void> {

    private Activity mActivity;
    private CityItemList mCityItemListResult;

    public FetchCitiesItemsTask(Activity _activity){

        mActivity = _activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Globals.mCityItemList.mCityItemList.clear();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if (mActivity != null && mCityItemListResult != null) {

            Globals.mCityItemList.mCityItemList.addAll(mCityItemListResult.mCityItemList);
        }

    }

    @Override
    protected Void doInBackground(Object... params) {

        try {

            mCityItemListResult = new WeatherFetchr().downloadCitiesItems("Donecka");
        } catch (IOException ioe) {

            //return new CityItemList();
        }
        return null;
    }
}
