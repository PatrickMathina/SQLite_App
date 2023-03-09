package com.example.sqlite_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final String DATABASE_NAME = "inventory_database.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_INVENTORY = "_inventory";
    private static final String KEY_PDT_CATEGORY = "product_category";
    private static final String KEY_PDT_ID = "product_id";
    private static final String KEY_PDT_NAME = "product_name";
    private static final String KEY_PDT_QUANTITY = "product_quantity";
    private static final String KEY_PDT_BP = "product_bp";
    private static final String KEY_PDT_SP = "product_sp";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query_Table = " CREATE TABLE " + TABLE_INVENTORY + "("
                + KEY_PDT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_PDT_CATEGORY + " TEXT, " + KEY_PDT_NAME + " TEXT, " + KEY_PDT_QUANTITY + " TEXT, " + KEY_PDT_BP + " INTEGER, " + KEY_PDT_SP + " INTEGER);";
        db.execSQL(Query_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INVENTORY);
        onCreate(db);
    }

    public boolean insertProduct(String category, String name, String quantity, int bp, int sp) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PDT_CATEGORY, category);
        values.put(KEY_PDT_NAME, name);
        values.put(KEY_PDT_QUANTITY, quantity);
        values.put(KEY_PDT_BP, bp);
        values.put(KEY_PDT_SP, sp);
        db.insert(TABLE_INVENTORY, null, values);

        return true;
    }


//    public ProductModel(String pdtCategory, String pdtId, String pdtName, String pdtQuantity, String pdtBp, String pdtSp) {
//        this.pdtCategory = pdtCategory;
//        this.pdtId = pdtId;
//        this.pdtName = pdtName;
//        this.pdtQuantity = pdtQuantity;
//        this.pdtBp = pdtBp;
//        this.pdtSp = pdtSp;
//    }

    public ArrayList<ProductModel> products() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorProducts = db.rawQuery("SELECT * FROM " + TABLE_INVENTORY, null);

        ArrayList<ProductModel> productModelArrayList = new ArrayList<>();

        if (cursorProducts.moveToFirst()) {
            while (cursorProducts.moveToNext()) {
                productModelArrayList.add(new ProductModel(cursorProducts.getString(1)
                        , cursorProducts.getString(2), cursorProducts.getString(3)
                        , cursorProducts.getString(4), cursorProducts.getString(5)
                        , cursorProducts.getString(6)));

            }
        }
            cursorProducts.close();
            return productModelArrayList;
        }
    }

