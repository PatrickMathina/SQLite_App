package com.example.sqlite_database;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DbHelper myDb;
    EditText editText_category, editText_name, editText_id, editText_quantity, editText_bp, editText_sp;
    int pdtId, pdtBp, pdtSp;
    String pdtCategory, pdtName, pdtQuantity;
    Button btn_save, btn_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_category = findViewById(R.id.category);
        editText_name = findViewById(R.id.name);
        editText_id = findViewById(R.id.id);
        editText_quantity = findViewById(R.id.quantity);
        editText_bp = findViewById(R.id.bp);
        editText_sp = findViewById(R.id.sp);
        btn_save = findViewById(R.id.btnSave);
        btn_view = findViewById(R.id.btnView);

        myDb = new DbHelper(this);

        btn_save.setOnClickListener(v -> {
            createPdt();
        });
        btn_view.setOnClickListener(v -> {
            viewPdt();
        });
    }

    public void createPdt() {
        pdtCategory = editText_category.getText().toString().trim();
//        id = Integer.parseInt(editText_id.getText().toString().trim());
        pdtName = editText_name.getText().toString().trim();
        pdtQuantity = editText_quantity.getText().toString().trim();
        pdtBp = Integer.parseInt(editText_bp.getText().toString().trim());
        pdtSp = Integer.parseInt(editText_sp.getText().toString().trim());

        if (pdtCategory.equals("") | pdtName.equals("") | pdtQuantity.equals("")) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();

        } else {
            myDb.insertProduct(pdtCategory, pdtName, pdtQuantity, pdtBp, pdtSp);
            editText_category.setText("");
            editText_id.setText("");
            editText_name.setText("");
            editText_quantity.setText("");
            editText_bp.setText("");
            editText_sp.setText("");
            Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public void viewPdt() {
        startActivity(new Intent(getApplicationContext(), DisplayActivity.class));
    }
}