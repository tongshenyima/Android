package com.example.day0428.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day0428.R;
import com.example.day0428.model.Country;

import java.util.List;


public class ContryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Country> countries;

    public ContryAdapter(List<Country> countries) {
        this.countries = countries;
    }

    public class ItemViewHoloder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView image;
        public ItemViewHoloder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            image=itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout,parent,false);
        return new ItemViewHoloder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemViewHoloder mHolder= (ItemViewHoloder) holder;
        mHolder.tvName.setText(countries.get(position).getName());
        mHolder.image.setImageResource(countries.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return countries != null ? countries.size() : 0;
    }
}
