package com.example.sessionmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText unameedt,passedt;
    Button loginbtn;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initListener();
        initObject();

    }

    private void initView() {
        unameedt = findViewById(R.id.uname_edt_login);
        passedt = findViewById(R.id.pwd_edt_login);
        loginbtn = findViewById(R.id.btn_login);

       if (!SessionManager.getuname(this).equals("")){
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
        }else {

       }
    }

    private void initObject() {
        db=new DBHelper(this);
    }

    private void initListener() {
        loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        String user=unameedt.getText().toString();
        String pass=passedt.getText().toString();

        if (db.checklogin(user,pass)){
            SessionManager.saveuname(user,LoginActivity.this);
            SessionManager.savepass(pass,LoginActivity.this);
            Intent i=new Intent(LoginActivity.this,HomeActivity.class);
            i.putExtra("Uname",unameedt.getText().toString().trim());
            startActivity(i);
            finish();
        }else {
            Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
        }

    }

}