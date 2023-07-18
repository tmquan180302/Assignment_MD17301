package com.example.assignment_md17301.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_md17301.R;
import com.example.assignment_md17301.model.Product;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ProductViewHolder> {

    private Context context;

    ArrayList<Product> list;

    public AdapterProduct(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = list.get(position);
        holder.txtid.setText("ID: " + product.getId());
        holder.txtname.setText("NAME: " + product.getName());
        holder.txtprice.setText("PRICE: " + product.getPrice());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView txtid, txtname, txtprice;
        Button btnUpdate, btnDelete;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.idProduct);
            txtname = itemView.findViewById(R.id.nameProduct);
            txtprice = itemView.findViewById(R.id.priceProduct);

            btnUpdate = itemView.findViewById(R.id.btnUpdate);
            btnDelete = itemView.findViewById(R.id.btnDelete);


        }
    }
}
