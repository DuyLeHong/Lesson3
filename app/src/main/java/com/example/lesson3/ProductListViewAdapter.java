package com.example.lesson3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductListViewAdapter extends ArrayAdapter<Product> {

    private ArrayList<Product> listProduct;

    public ProductListViewAdapter(@NonNull Context context, int resource, ArrayList<Product> _listProduct) {
        super(context, resource);
        listProduct = _listProduct;
    }

//    public ProductListViewAdapter(ArrayList<Product> _listProduct) {
//        listProduct = _listProduct;
//    }

    @Override
    public int getCount() {
        return listProduct.size();
    }
//
//    @Override
//    public Object getItem(int position) {
//        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
//        //có chỉ số position trong listProduct
//        return listProduct.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        //Trả về một ID của phần
//        return listProduct.get(position).productID;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
        //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
        //Nếu null cần tạo mới

        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
        } else viewProduct = convertView;

        //Bind sữ liệu phần tử vào View
        Product product = listProduct.get(position);
        ((TextView) viewProduct.findViewById(R.id.idproduct)).setText(String.format("ID = %d", product.productID));
        ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("Tên SP : %s", product.name));
        ((TextView) viewProduct.findViewById(R.id.priceproduct)).setText(String.format("Giá %d", product.price));


        return viewProduct;
    }
}
