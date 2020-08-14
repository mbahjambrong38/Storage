package com.baru.storage;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Vector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputStock extends AppCompatActivity{

    @BindView(R.id.list_plant)
    Spinner listPlant;
    @BindView(R.id.list_storage_location)
    Spinner listStorageLocation;
    @BindView(R.id.list_material)
    Spinner listMaterial;
    @BindView(R.id.edt_stock)
    EditText edtStock;
    @BindView(R.id.btn_input_stock)
    Button btnInputStock;

    ArrayList<String> LIST_PLANT1 = new ArrayList<>();

    Vector<String> LIST_PLANT = new Vector<>();
    Vector<String> LIST_MATERIAL = new Vector<>();
    Vector<String> LIST_STORAGE_LOCATION = new Vector<>();

    void addSpinner(){
//        for (int i = 0; i < db.VEC_PLANT.size(); i++){
//            LIST_PLANT1.add(db.VEC_PLANT.get(i).plantDesc);
//        }
//        for (int i = 0; i < db.VEC_MATERIAL.size(); i++){
//            LIST_MATERIAL.add(db.VEC_MATERIAL.get(i).materialDesc);
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_stock);
        ButterKnife.bind(this);

        addSpinner();

        ArrayAdapter<String> adapterPlant = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,LIST_PLANT);
        ArrayAdapter<String> adapterMaterial = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,LIST_MATERIAL);

        listMaterial.setAdapter(adapterMaterial);
        listPlant.setAdapter(adapterPlant);

//        listStorageLocation.setOnItemSelectedListener(onItemSelected());
//        listMaterial.setOnItemSelectedListener(this);
//        listPlant.setOnItemSelectedListener();
    }

    @OnClick({R.id.btn_input_stock})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_input_stock:
                break;
        }
    }


    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        switch (adapterView.getId()){
            case R.id.list_material:
                break;
            case R.id.list_plant:
//                for(int i = 0; i < db.VEC_STORAGE_LOCATION.size(); i++){
//                    if((position+1) == db.VEC_STORAGE_LOCATION.get(i).plantID){
//                        LIST_STORAGE_LOCATION.add(db.VEC_STORAGE_LOCATION.get(i).locationDesc);
//                    }
//                }
                ArrayAdapter<String> adapterStorageLocation = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,LIST_STORAGE_LOCATION);
                listStorageLocation.setAdapter(adapterStorageLocation);
                break;
            case R.id.list_storage_location:
                break;
        }
    }


}