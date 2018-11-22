package com.skanderjabouzi.listviewsections;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SectionListView2 extends Activity {

    private CustomAdapter2 mAdapter;
    private HashMap<String, ArrayList<String>> list;
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        mAdapter = new CustomAdapter2(this);
        listView = findViewById(R.id.list);
        listView.setAdapter(mAdapter);
        list = new HashMap<>();
        ArrayList<String> data1 = new ArrayList<String>();
        ArrayList<String> data2 = new ArrayList<String>();

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int type = listView.getAdapter().getItemViewType(position);
                if (type == 0) {
                    String selectedValue = (String) listView.getAdapter().getItem(position);
                    Toast.makeText(SectionListView2.this, "You Clicked at " + position + ": " + selectedValue, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}




