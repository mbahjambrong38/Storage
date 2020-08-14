package com.baru.storage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.baru.storage.preferences.Preferences;
import com.baru.storage.request.Request;
import com.baru.storage.user.LogedUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {

    @BindView(R.id.edtUserName)
    EditText edtUserName;
    @BindView(R.id.edtUserPass)
    EditText edtUserPass;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Preferences.setContext(this);
        LogedUser.userName = Preferences.getUserName();
        LogedUser.userPassword = Preferences.getUserPassword();
        LogedUser.userID = Preferences.getUserID();

        if (LogedUser.userID != 0) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        edtUserName.addTextChangedListener(loginTextWatcher);
        edtUserPass.addTextChangedListener(loginTextWatcher);
    }

    TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String userName = edtUserName.getText().toString().trim();
            String userPass = edtUserPass.getText().toString().trim();

            btnLogin.setEnabled(!userName.isEmpty() && !userPass.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    @OnClick(R.id.btnLogin)
    public void onViewClicked(){
        String userName = edtUserName.getText().toString().trim();
        String userPass = edtUserPass.getText().toString().trim();

        String URL_READ_USER = String.format("https://storagependi.pw/read_user.php?user_name=%s&user_password=%s", userName, userPass);

        Request request = new Request(Login.this, this);
        request.getJson("User", URL_READ_USER);


    }

}