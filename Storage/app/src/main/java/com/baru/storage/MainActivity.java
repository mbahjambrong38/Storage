package com.baru.storage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.baru.storage.preferences.Preferences;
import com.baru.storage.request.Request;
import com.baru.storage.user.LogedUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_input_main)
    Button btnInputMain;
    @BindView(R.id.btn_view_main)
    Button btnViewMain;

    static String URL_READ_PLANT = "https://storagependi.pw/read_plant.php";
    static String URL_READ_STORAGE_LOCATION = "https://storagependi.pw/read_storage_location.php";
    static String URL_READ_STOCK = "https://storagependi.pw/read_stock.php";
    static String URL_READ_MATERIAL = "https://storagependi.pw/read_material.php";
    static String URL_READ_USER = "https://storagependi.pw/read_material.php?user_name=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Request request = new Request(MainActivity.this, this);

        request.getJson(URL_READ_MATERIAL, "Material");
        request.getJson(URL_READ_PLANT, "Plant");
        request.getJson(URL_READ_STOCK, "Stock");
        request.getJson(URL_READ_STORAGE_LOCATION, "Storage_Location");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);

        menu.findItem(R.id.menuProfile).setTitle(LogedUser.userName);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuHistory:
                return true;

            case R.id.menuLogout:
                Preferences.setContext(this);
                Preferences.actionLogout();
                startActivity(new Intent(MainActivity.this, Login.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick({R.id.btn_input_main, R.id.btn_view_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_input_main:
                Intent intent = new Intent(MainActivity.this, InputStock.class);
                startActivity(intent);
                break;
            case R.id.btn_view_main:
                intent = new Intent(MainActivity.this, ViewStock.class);
                startActivity(intent);
                break;
        }
    }
}