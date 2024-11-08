package com.example.verticalrecyclerview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class F_RecyclerViewAdapter extends RecyclerView.Adapter<F_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<FilterModel> filterModels;

    public F_RecyclerViewAdapter(Context context, ArrayList<FilterModel> filterModels) {
        this.context = context;
        this.filterModels = filterModels;
    }

    @NonNull
    @Override
    public F_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Method ini akan menginflate layout (membuat tampilan untuk baris-baris)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new F_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull F_RecyclerViewAdapter.MyViewHolder holder, int position) {
        // Mengassign nilai ke views yang telah dibuat di dalam file layout recycler_view_row
        // berdasarkan posisi dari RecyclerView
        holder.textView.setText(filterModels.get(position).getFilterName());
        holder.imageView.setImageResource(filterModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        // RecyclerView ingin mengetahui berapa banyak item yang ingin ditampilkan
        return filterModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // Mengambil View yang ada di dalam file layout recycler_view_row

        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);

        }
    }
}
