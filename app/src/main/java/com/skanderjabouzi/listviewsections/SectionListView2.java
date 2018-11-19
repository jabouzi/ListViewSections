package com.skanderjabouzi.listviewsections;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionListView2 extends ListActivity {

    private CustomAdapter mAdapter;
    private HashMap<String, ArrayList<String>> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new CustomAdapter(this);
        list = new HashMap<>();
        ArrayList<String> data1 = new ArrayList<String>();
        ArrayList<String> data2 = new ArrayList<String>();
//        String[] sections = new String[] {"Section", "Section2"};

//        mAdapter = new CustomAdapter(this);
        for (int i = 1; i < 20; i++) {
            data1.add("Row Item #" + i + "Section # 1");
        }
        for (int i = 1; i < 15; i++) {
            data2.add("Row Item #" + i + "Section # 2");
        }

        list.put("Section 1", data1);
        list.put("Section 2", data2);

        for (Map.Entry<String, ArrayList<String>> m : list.entrySet()) {
            Log.e("SECTION: ", m.getKey());
            mAdapter.addSectionHeaderItem(m.getKey());
            ArrayList<String> value = m.getValue();
            for (int i = 0; i < value.size(); i++) {
                mAdapter.addItem(value.get(i));
            }
        }

        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //get selected items
        int type = getListAdapter().getItemViewType(position);
        if (type == 0) {
            String selectedValue = (String) getListAdapter().getItem(position);
            Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
        }
    }
}
