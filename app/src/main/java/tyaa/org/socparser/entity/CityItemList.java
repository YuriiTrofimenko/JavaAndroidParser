package tyaa.org.socparser.entity;

import android.databinding.ObservableArrayList;
import android.view.View;

/**
 * Created by student on 12.08.2017.
 */

public class CityItemList implements ICityItemList {

    public ObservableArrayList<CityItem> mCityItemList = new ObservableArrayList<>();
    public CityItem mCityItem;
    public Integer mSelectedCityPosition = 0;

    public CityItemList() {}

    // Called on add button click
    public void add(View v) {

        mCityItemList.add(new CityItem());
    }

    // Called on remove button click
    public void remove(View v) {

        if (!mCityItemList.isEmpty()) {
            mCityItemList.remove(0);
        }
    }

    public Integer getSelectedCityPosition() {

        return mSelectedCityPosition;
    }

    public void setSelectedCityPosition(Integer _selectedCityPosition) {

        mSelectedCityPosition = _selectedCityPosition;
        mCityItem = mCityItemList.get(mSelectedCityPosition);
    }

    public void setCity_item_list(ObservableArrayList<CityItem> _cityItemList) {

        mCityItemList = _cityItemList;
    }

    public void setCity_item(CityItem _cityItem) {

        mCityItemList.add(_cityItem);
    }
}
