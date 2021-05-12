package tyaa.org.socparser.binder;

import android.widget.ListView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;

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
