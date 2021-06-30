package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEtUserName;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mbtnLogin;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtEmail = findViewById(R.id.UserEmail);
        mEtUserName = findViewById(R.id.etuserName);
        mEtPassword = findViewById(R.id.password);
        mbtnLogin = findViewById(R.id.btnforLogin);
        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isuserNamevalid = isUserNameValid();
                boolean isPasswordValid = isPasswordValid();
                boolean isEmailvalid = isEmailValid();
                if (isEmailvalid && isPasswordValid && isuserNamevalid) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("username", mEtUserName.getText().toString());
                    startActivity(intent);
                }


            }
        });
    }

    private boolean isEmailValid() {
        if (mEtEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEmail.setError("Invalid email");
            return false;
        }
    }

    private boolean isUserNameValid() {
        if (mEtUserName.getText().toString().trim().length() >= 4) {
            return true;

        } else {
            mEtUserName.setError("Username is not valid");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (mEtPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            mEtPassword.setError("Password length is less than 6 charactre");
            return false;
        }
    }
}




