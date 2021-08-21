package com.example.sessionmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText uname_edt,email_edt,pass_edt,cpass_edt;
    Button signupbtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        db = new DBHelper(this);
        uname_edt=findViewById(R.id.uname_edt_reg);
        email_edt=findViewById(R.id.email_edt_reg);
        pass_edt=findViewById(R.id.pwd_edt_reg);
        cpass_edt=findViewById(R.id.cpwd_edt_reg);
        signupbtn=findViewById(R.id.reg_btn);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = uname_edt.getText().toString().trim();
                String email = email_edt.getText().toString().trim();
                String pwd = pass_edt.getText().toString().trim();
                String cpwd = cpass_edt.getText().toString().trim();
                if (pwd.equals(cpwd)) {
                    db.adduser(uname, email,pwd);

                    Toast.makeText(SignUpActivity.this, "You have signup", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(SignUpActivity.this, " signup failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}