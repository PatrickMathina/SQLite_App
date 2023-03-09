package com.example.sqlite_database;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    ListView listView_product;
    DbHelper dbHelper;
    List<ProductModel> list;
    Adapter_product adapter_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        listView_product = findViewById(R.id.listview);

        dbHelper = new DbHelper(getApplicationContext());

        list = new ArrayList<>();
        list = dbHelper.products();

        adapter_product = new Adapter_product(getApplicationContext(), list);

        listView_product.setAdapter(adapter_product);
    }
}