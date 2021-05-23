package com.example.financesproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "finance.db";

    public static final String TABLE = "expenses";
    public static final String COLUMN_ID = "expense_id";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_CATEGORY = "category";

    /*public static final String ITABLE = "incomes";
    public static final String ICOLUMN_ID = "income_id";
    public static final String ICOLUMN_QUANTITY = "quantity";
    public static final String ICOLUMN_DATE = "date";
    public static final String ICOLUMN_CATEGORY = "category";*/

    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " +
                TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_QUANTITY + " FLOAT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_CATEGORY + " TEXT)";

        db.execSQL(CREATE_TABLE);

        /*CREATE_TABLE = "CREATE TABLE " +
                ITABLE + "(" +
                ICOLUMN_ID + " INTEGER PRIMARY KEY, " +
                ICOLUMN_QUANTITY + " FLOAT, " +
                ICOLUMN_DATE + " TEXT, " +
                ICOLUMN_CATEGORY + " TEXT)";

        db.execSQL(CREATE_TABLE);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        //db.execSQL("DROP TABLE IF EXISTS " + ITABLE);
        onCreate(db);
    }

    public void addExpense(float quantity, String date, String category) {
        System.out.println("Quantity "+ quantity + " date "+ date + "cat " +category);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUANTITY, quantity);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_CATEGORY, category);
        db.insert(TABLE, null, values);
    }

    public Expense getExpenses() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE;
        Cursor cursor = db.rawQuery(query, null);
        Expense exp = null;
        if(cursor.moveToFirst()) {
            exp = new Expense(cursor.getFloat(0), cursor.getString(1),
                    cursor.getString(2));
        }
        cursor.close();
        db.close();
        return exp;
    }

    public Expense findExpense(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE + " WHERE " +
                COLUMN_ID + "= \"" + id + "\"";
        Cursor cursor = db.rawQuery(query, null);
        Expense exp = null;
        if(cursor.moveToFirst()) {
            exp = new Expense(cursor.getFloat(0), cursor.getString(1),
                    cursor.getString(2));
        }
        cursor.close();
        db.close();
        return exp;
    }

    public boolean deleteExpense(int id) {
        boolean result = false;
        Expense exp = findExpense(id);
        if(exp != null) {
            SQLiteDatabase db = this.getWritableDatabase();
            String[] values = new String[1];
            values[0] = String.valueOf(exp.getId());
            db.delete(TABLE, COLUMN_ID + "=?", values);
            db.close();
            result = true;
        }
        return result;
    }

    /*--------------------------------------------------------*/
    /*public void addIncome(String name, float quantity, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ICOLUMN_QUANTITY, quantity);
        values.put(ICOLUMN_DATE, date);
        db.insert(ITABLE, null, values);
    }

    public Income getIncomes() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + ITABLE;
        Cursor cursor = db.rawQuery(query, null);
        Income inc = null;
        if(cursor.moveToFirst()) {
            inc = new Income(cursor.getFloat(0), cursor.getString(1),
                    cursor.getString(2));
        }
        cursor.close();
        db.close();
        return inc;
    }

    public Income findIncome(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + ITABLE + " WHERE " +
                ICOLUMN_ID + "= \"" + id + "\"";
        Cursor cursor = db.rawQuery(query, null);
        Income inc = null;
        if(cursor.moveToFirst()) {
            inc = new Income(cursor.getFloat(0), cursor.getString(1),
                    cursor.getString(2));
        }
        cursor.close();
        db.close();
        return inc;
    }

    public boolean deleteIncome(int id) {
        boolean result = false;
        Income inc = findIncome(id);
        if(inc != null) {
            SQLiteDatabase db = this.getWritableDatabase();
            String[] values = new String[1];
            values[0] = String.valueOf(inc.getId());
            db.delete(ITABLE, ICOLUMN_ID + "=?", values);
            db.close();
            result = true;
        }
        return result;
    }*/
}
