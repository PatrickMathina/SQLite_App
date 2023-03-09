package com.example.sqlite_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter_product extends BaseAdapter {
    Context context;
    List<ProductModel> productModels;

    public Adapter_product(Context context, List<ProductModel> productModels) {
        this.context = context;
        this.productModels = productModels;
    }

    public Adapter_product() {

    }

    @Override
    public int getCount() {
        return productModels.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.product_format, parent, false);
        }

        TextView pdt_category = convertView.findViewById(R.id.category);
        TextView pdt_id = convertView.findViewById(R.id.id);
        TextView pdt_name = convertView.findViewById(R.id.name);
        TextView pdt_quantity = convertView.findViewById(R.id.quantity);
        TextView pdt_bp = convertView.findViewById(R.id.bp);
        TextView pdt_sp = convertView.findViewById(R.id.sp);

        ProductModel model = productModels.get(position);

        pdt_category.setText(String.valueOf(model.getPdtCategory()));
        pdt_id.setText(String.valueOf(model.getPdtId()));
        pdt_name.setText(String.valueOf(model.getPdtName()));
        pdt_quantity.setText(String.valueOf(model.getPdtQuantity()));
        pdt_bp.setText(String.valueOf(model.getPdtBp()));
        pdt_sp.setText(String.valueOf(model.getPdtSp()));

        return convertView;
    }
}
