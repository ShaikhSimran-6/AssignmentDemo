package com.example.android.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.Model.ProductModel;
import com.example.android.ProductDetailActivity;
import com.example.android.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    //    private static final int TYPE_TITLE = 0;
//    private static final int TYPE_PRODUCT = 1;
    private Context context;
    private List<ProductModel> items;

    public ProductAdapter(Context context, List<ProductModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_product, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {

        ProductModel product = items.get(position);
        holder.title.setText(product.getTitle());
        holder.price.setText("Price: $" + product.getPrice());
        holder.rating.setText("Rating: " + product.getRating());
        holder.shipping.setText("Shipping: " + product.getShippingInformation());

        // Load the first image from the list of images
        if (product.getImages() != null && !product.getImages().isEmpty()) {
            Picasso.get().load(product.getImages().get(0)).into(holder.image);
        } else {
            // Handle case where there are no images
            holder.image.setImageResource(R.drawable.placeholder_image);
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("product", product);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, price, rating, shipping;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.product_title);
            price = itemView.findViewById(R.id.product_price);
            rating = itemView.findViewById(R.id.product_rating);
            shipping = itemView.findViewById(R.id.product_shipping_availability);
            image = itemView.findViewById(R.id.product_image);
        }
    }


//    @Override
//    public int getItemViewType(int position) {
//        if (position == 0) {
//            return TYPE_TITLE;
//        } else {
//            return TYPE_PRODUCT;
//        }
//    }

//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        if (viewType == TYPE_TITLE) {
//            View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
//            return new TitleViewHolder(view);
////        } else {
////            View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
////            return new ProductViewHolder(view);
////        }
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

//        if (holder.getItemViewType() == TYPE_TITLE) {
//            ((TitleViewHolder) holder).title.setText("Products List");
//        } else {
//            ProductModel product = (ProductModel) items.get(position);
//            ProductViewHolder productHolder = (ProductViewHolder) holder;
//            productHolder.title.setText(product.getTitle());
//            productHolder.price.setText("Price: $" + product.getPrice());
//            productHolder.rating.setText("Rating: " + product.getRating());
//            productHolder.shipping.setText("Shipping: " + product.getShippingInformation());
//
//            // Load the first image from the list of images
//            if (product.getImages() != null && !product.getImages().isEmpty()) {
//                Picasso.get().load(product.getImages().get(0)).into(productHolder.image);
//            } else {
//                // Handle case where there are no images
//                productHolder.image.setImageResource(R.drawable.placeholder_image);
//            }
//
//            productHolder.itemView.setOnClickListener(v -> {
//                Intent intent = new Intent(context, ProductDetailActivity.class);
//                intent.putExtra("product", product);
//                context.startActivity(intent);
//            });
//        }
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return product.size;
//    }

//    static class TitleViewHolder extends RecyclerView.ViewHolder {
//        TextView title;
//
//        public TitleViewHolder(@NonNull View itemView) {
//            super(itemView);
//            title = itemView.findViewById(R.id.title);
//        }
//    }

//    public static class ProductViewHolder extends RecyclerView.ViewHolder {
//        TextView title, price, rating, shipping;
//        ImageView image;
//
//        public ProductViewHolder(@NonNull View itemView) {
//            super(itemView);
//            title = itemView.findViewById(R.id.product_title);
//            price = itemView.findViewById(R.id.product_price);
//            rating = itemView.findViewById(R.id.product_rating);
//            shipping = itemView.findViewById(R.id.product_shipping_availability);
//            image = itemView.findViewById(R.id.product_image);
//            }
//        }
//
}
