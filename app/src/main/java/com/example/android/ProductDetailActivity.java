package com.example.android;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.Adapter.ReviewAdapter;
import com.example.android.Model.ProductModel;
import com.squareup.picasso.Picasso;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView productTitle, productDescription, productPrice, productDiscountedPrice, productRating, productWarranty, productShipping, productStock, productReviews;

    private RecyclerView recyclerViewReviews;
    private ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        recyclerViewReviews = findViewById(R.id.review_rv);
        recyclerViewReviews.setLayoutManager(new LinearLayoutManager(this));

        // Initialize views
        productImage = findViewById(R.id.product_image_d);
        productTitle = findViewById(R.id.product_title);
        productDescription = findViewById(R.id.product_description);
        productPrice = findViewById(R.id.product_price);
        productDiscountedPrice = findViewById(R.id.product_discounted_price);
        productRating = findViewById(R.id.product_rating);
        productWarranty = findViewById(R.id.product_warranty);
        productShipping = findViewById(R.id.product_shipping);
        productStock = findViewById(R.id.product_stock);

        // Get the product data from intent
        ProductModel product = (ProductModel) getIntent().getSerializableExtra("product");

        if (product != null) {
            reviewAdapter = new ReviewAdapter(product.getReviews());
            recyclerViewReviews.setAdapter(reviewAdapter);
        }

        // Populate the views with product data
            productTitle.setText(product.getTitle());
            productDescription.setText(product.getDescription());
            productPrice.setText("Price: $" + product.getPrice());
            productDiscountedPrice.setText("Discounted Price: $" + product.getDiscountPercentage());
            productRating.setText("Rating: " + product.getRating());
            productWarranty.setText("Warranty: " + product.getWarrantyInformation());
            productShipping.setText("Shipping: " + product.getShippingInformation());
            productStock.setText("Stock: " + product.getStock());


            // Load the product image
            if (product.getImages() != null && !product.getImages().isEmpty()) {
                Picasso.get().load(product.getImages().get(0)).into(productImage);
            } else {
                // Handle case where there are no images
                productImage.setImageResource(R.drawable.placeholder_image);
            }



    }
}





