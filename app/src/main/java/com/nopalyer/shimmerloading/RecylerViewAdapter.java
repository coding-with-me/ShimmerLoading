package com.nopalyer.shimmerloading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHolder>{


    ArrayList<model> models = new ArrayList<>();
    Context context;

    boolean isShimmer = true;
    int shimmerNumber = 5;

    public RecylerViewAdapter(ArrayList<model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (isShimmer){
            holder.shimmerFrameLayout.startShimmer();
        }else{
            holder.shimmerFrameLayout.stopShimmer();
            holder.shimmerFrameLayout.setShimmer(null);

            holder.tvTitle.setBackground(null);
            holder.tvTitle.setText(models.get(position).getTitle());

            holder.tvDesc.setBackground(null);

            holder.tvDesc.setText(models.get(position).getDesc());

            holder.imageView.setBackground(null);
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.logo));
        }
    }

    @Override
    public int getItemCount() {
        return isShimmer?shimmerNumber:models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ShimmerFrameLayout shimmerFrameLayout;
        TextView tvTitle,tvDesc;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            shimmerFrameLayout = itemView.findViewById(R.id.shimmerFrameLayout);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
