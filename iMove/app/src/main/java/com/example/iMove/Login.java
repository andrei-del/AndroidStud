package com.example.iMove;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText usr;
    private EditText pass;

    public void logIn(View v) {
        this.usr=(EditText)findViewById(R.id.username);
        this.pass=(EditText)findViewById(R.id.password);


        String usrText= this.usr.getText().toString();
        String passText=this.pass.getText().toString();

        System.out.println(usrText);
        System.out.println(passText);


        if(usrText.equals("iMove")==true && passText.equals("parolaiMove")==true){
            Intent i=new Intent(this, MainActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(Login.this,"wrong username or password",Toast.LENGTH_LONG).show();
        }



    }
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
