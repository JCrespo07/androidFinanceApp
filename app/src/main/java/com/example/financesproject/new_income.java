package com.example.financesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class new_income extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_income);
    }
    public void toHome(View v)
    {
        Intent myintent = new Intent(this, MainActivity.class);
        startActivity(myintent);
    }
}