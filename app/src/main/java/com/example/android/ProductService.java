package com.example.android;

import com.example.android.Model.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {

    @GET("products")
    Call<ProductResponse> getProducts();

}
