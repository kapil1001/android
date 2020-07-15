package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText Name, Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Name = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.button);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()){
                    validate();
                }
            }
        });
    }
    private boolean validation(){
        boolean isValidated = true;
        String name = Name.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if(name.isEmpty()){
            Name.setError("Please Enter your Username");
            isValidated = false;
        }
        if(password.isEmpty()){
            Password.setError("Enter Your Password");
            isValidated = false;
        }
        return  isValidated;
    }

    private void validate(){
        String userName = Name.getText().toString().trim();
        String userPassword = Password.getText().toString().trim();

        if(userName.equals("softwarica") && userPassword.equals("coventry")){
            Intent intent = new Intent(com.example.navigation.Login.this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
        }
    }
}
