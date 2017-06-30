package com.example.workfit.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.app.LauncherActivity.ListItem;

import com.example.workfit.DataFiles.StatisticData;
import com.example.workfit.workfitapps.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Revina Adisty on 6/5/2017.
 */

public class StatisticExpandedListAdapter extends BaseExpandableListAdapter {

    Context context;
    StatisticData Data;

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        /**
         * Inflate layout list_group_header sesuai dengan int i sebagai indeks grup.
         */
        View v = view;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.statistic_list_group_header_items, null);
        }

        TextView headerName = (TextView)v.findViewById(R.id.groupHeader);
        headerName.setText(Data.getHeaderName(i));
        TextView headerSubName = (TextView)v.findViewById(R.id.groupSubHeader);
        headerSubName.setText(Data.getHeaderSubName(i, context));

        return v;
    }

    @Override
    public View getChildView(int groupIndex, int childIndex, boolean b, View view, ViewGroup viewGroup) {

        View v = view;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.statistic_list_group_child, null);
        }

        ListView childItems = (ListView) v.findViewById(R.id.childList);
        SimpleAdapter adapter = new SimpleAdapter(v.getContext(), Data.getFullChildArray(groupIndex),
                R.layout.statistic_list_group_child_items,new String[]{"child1", "child2"},
                new int[]{R.id.child1, R.id.child2});

        childItems.setAdapter(adapter);

        return v;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
