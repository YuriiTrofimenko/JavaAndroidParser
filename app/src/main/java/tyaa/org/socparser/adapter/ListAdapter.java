package tyaa.org.socparser.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import tyaa.org.socparser.R;
import tyaa.org.socparser.databinding.CityitemBinding;
import tyaa.org.socparser.entity.CityItem;

/**
 * Created by yurii on 18.08.17.
 */

public class ListAdapter extends BaseAdapter {

    private ObservableArrayList<CityItem> list;
    private LayoutInflater inflater;

    public ListAdapter(ObservableArrayList<CityItem> l) {

        list = l;
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {

            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        CityitemBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.cityitem, parent, false);
        Log.d("MySpy", "bind!");
        binding.setItem(list.get(position));

        return binding.getRoot();
    }
}
