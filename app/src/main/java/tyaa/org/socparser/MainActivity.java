package tyaa.org.socparser;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import tyaa.org.socparser.controller.FetchCitiesItemsTask;
import tyaa.org.socparser.databinding.MainBinding;
import tyaa.org.socparser.entity.CityItemList;
import tyaa.org.socparser.global.Globals;

//import tyaa.org.socparser.databinding.*;

public class MainActivity extends AppCompatActivity {

    CityItemList cityItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        MainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.main);
        cityItemList = Globals.mCityItemList;
        activityMainBinding.setItems(cityItemList);
        activityMainBinding.setItemClickHandler(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Toast.makeText(getBaseContext(), cityItemList.mCityItemList.get(i).name, Toast.LENGTH_SHORT).show();
                    }
                }
        );

        /* ListView listView1 = (ListView) findViewById(R.id.listView);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getBaseContext(), cityItemList.mCityItemList.get(i).name, Toast.LENGTH_SHORT).show();
            }
        }); */

        /*CityItem cityItem = new CityItem("NewYork");
        cityItemList.setCity_item(cityItem);
        cityItem = new CityItem("Mariupol");
        cityItemList.setCity_item(cityItem);
        cityItem = new CityItem("Moscow");
        cityItemList.setCity_item(cityItem);*/

        FetchCitiesItemsTask fetchCitiesItemsTask = new FetchCitiesItemsTask(this);
        CityItemList tmpCityItemList = null;
        //fetchCitiesItemsTask.execute();
        fetchCitiesItemsTask.execute();
        /*if (tmpCityItemList != null){

            for (CityItem cityItem: tmpCityItemList.mCityItemList) {

                Globals.mCityItemList.setCity_item(cityItem);
            }
        }*/
    }
}
