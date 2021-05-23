package com.example.financesproject;

public class Expense {
    private int id;
    private float quantity;
    private String date;
    private String category;

    public Expense(int id, float quantity, String date, String category) {
        this.id = id;
        this.quantity = quantity;
        this.date = date;
        this.category = category;
    }

    public Expense(float quantity, String date, String category) {
        this.quantity = quantity;
        this.date = date;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
