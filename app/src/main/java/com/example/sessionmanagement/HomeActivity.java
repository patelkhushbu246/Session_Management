package com.example.sessionmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView txtemail,txtuname;
    MenuItem menuItem;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtuname=findViewById(R.id.uname_txt);
        txtemail=findViewById(R.id.email_txt);

        Intent i=getIntent();
        if (i.hasExtra("Uname") ) {
           String uname=getIntent().getStringExtra("Uname");
            txtuname.setText("Welcome:  "+uname);


        }else if( i.hasExtra("Email")){
            String email=getIntent().getStringExtra("Email");
            txtemail.setText("Email: "+email);
        }
        else  {
            String uname1 = SessionManager.getuname(this);
            txtuname.setText("Username:  "+uname1);
            String email1 = SessionManager.getemail(this);
            txtemail.setText("Email:  "+email1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        menuItem=menu.findItem(R.id.action_loguot);

        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                SessionManager.savepass("",HomeActivity.this);
                SessionManager.saveuname("",HomeActivity.this);
                Intent i=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}