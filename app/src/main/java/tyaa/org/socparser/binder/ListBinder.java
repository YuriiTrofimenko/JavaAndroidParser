package tyaa.org.socparser.binder;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import tyaa.org.socparser.adapter.ListAdapter;
import tyaa.org.socparser.entity.CityItem;

/**
 * Created by yurii on 18.08.17.
 */

public class ListBinder {

    @BindingAdapter({"bind:city_item_list"})
    public static void bindList(ListView view, ObservableArrayList<CityItem> list) {

        ListAdapter adapter = new ListAdapter(list);
        view.setAdapter(adapter);
    }
}
