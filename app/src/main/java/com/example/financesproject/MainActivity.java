package com.example.financesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity<onClickListener> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendToExpense(View v)
    {
        Intent myintent = new Intent(MainActivity.this, new_expense.class);
        startActivity(myintent);
    }
    public void sendToIncome(View v)
    {
        Intent myintent = new Intent(MainActivity.this, new_income.class);
        startActivity(myintent);
    }

}