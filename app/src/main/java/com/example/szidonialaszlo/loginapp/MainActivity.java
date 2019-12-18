package com.example.szidonialaszlo.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button LoginButton;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.namePlainText);
        Password = (EditText) findViewById(R.id.passwordPlainText);
        Info = (TextView) findViewById(R.id.infoTextView);
        LoginButton = (Button) findViewById(R.id.loginBtn);

        Info.setText("Number of attempts remaining: 5");

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }


    private void validate(String userName, String userPassword){
        if (userName.equals("Admin")  && userPassword.equals("1234")){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class); //Context - ez, ha jo minden => SecondActivity
            startActivity(intent);

        }else{
            counter--;
            Info.setText("Number of attempts remaining: "+String.valueOf(counter));
            if (counter == 0){
                LoginButton.setEnabled(false);  //nem lesz elerheto a gomb
            }
        }

    }
}
