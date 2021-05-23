package com.example.financesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class new_expense extends AppCompatActivity {
    DBHandler handler;
    TextView title;
    EditText expenseTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expense);

        handler = new DBHandler(this, null, null, 1);
        title = findViewById(R.id.expenseLabel);
        expenseTxt = findViewById(R.id.expenseInput);

    }
    public void toHome(View v)
    {
        Intent myintent = new Intent(new_expense.this, MainActivity.class);
        startActivity(myintent);
    }

    public void add(View v) {
        if(!expenseTxt.equals("")) {
            Date c = Calendar.getInstance().getTime();
            System.out.println("Current time => " + c);

            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
            String formattedDate = df.format(c);
            handler.addExpense(Float.parseFloat(expenseTxt.getText().toString()), formattedDate, "Category");
            title.setText("Expense Added");
            expenseTxt.setText("");
        } else {
            title.setText("Expense not added");
        }
    }

}