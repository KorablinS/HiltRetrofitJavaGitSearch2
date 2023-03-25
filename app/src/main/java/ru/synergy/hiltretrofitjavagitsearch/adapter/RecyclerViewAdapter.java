package ru.synergy.hiltretrofitjavagitsearch.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ru.synergy.hiltretrofitjavagitsearch.R;
import ru.synergy.hiltretrofitjavagitsearch.models.RecyclerData;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private List<RecyclerData> listItems;

    public void setListItems(List<RecyclerData> listItems) {
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvName.setText(listItems.get(position).getName());
        holder.tvDesc.setText(listItems.get(position).getDescription());
        Glide.with(holder.imageView)
                .load(listItems.get(position).getOwner().getAvatar_url())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName;
        TextView tvDesc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDesc = itemView.findViewById(R.id.tvDesc);

        }
    }
}
