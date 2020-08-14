package com.baru.storage.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Vector;

public class AdapterView extends BaseAdapter {

    Context ctx;

    Vector<Integer> VEC_MATERIAL_ID = new Vector<>();
    Vector<String> VEC_MATERIAL_DESC = new Vector<>();

    Vector<Integer> VEC_STORAGE_LOCATION_ID = new Vector<>();
    Vector<String> VEC_STORAGE_LOCATION_DESC = new Vector<>();

    Vector<Integer> VEC_PLANT_ID = new Vector<>();
    Vector<String> VEC_PLANT_DESC = new Vector<>();

    Vector<Integer> VEC_STOCK_QTY = new Vector<>();
    Vector<Integer> VEC_STOCK_TOTAL_VALUATION = new Vector<>();


    public AdapterView(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
