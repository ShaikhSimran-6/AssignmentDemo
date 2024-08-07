package com.example.android.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.Model.ReviewModel;
import com.example.android.R;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>{

    private List<ReviewModel> reviews;

    public ReviewAdapter(List<ReviewModel> reviews) {
        this.reviews = reviews;
    }

    @NonNull
    @Override
    public ReviewAdapter.ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item_card, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ReviewViewHolder holder, int position) {

        ReviewModel review = reviews.get(position);
        holder.rating.setText("Rating: " + review.getRating());
        holder.comment.setText(review.getComment());
        holder.date.setText(review.getDate());
        holder.reviewerName.setText(review.getReviewerName());
        holder.reviewerEmail.setText(review.getReviewerEmail());

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public static class ReviewViewHolder extends RecyclerView.ViewHolder {

        TextView rating, comment, date, reviewerName, reviewerEmail;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);

            rating = itemView.findViewById(R.id.rating);
            comment = itemView.findViewById(R.id.reviewer_comment);
            date = itemView.findViewById(R.id.reviewer_date);
            reviewerName = itemView.findViewById(R.id.reviewer_name);
            reviewerEmail = itemView.findViewById(R.id.reviewer_email);
        }
    }
}
