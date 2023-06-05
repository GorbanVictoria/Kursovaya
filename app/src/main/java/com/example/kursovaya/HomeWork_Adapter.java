package com.example.kursovaya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeWork_Adapter extends RecyclerView.Adapter<HomeWork_Adapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final ArrayList<HomeWorkTask> tasks;




    HomeWork_Adapter(Context context, ArrayList<HomeWorkTask> tasks) {
        this.tasks = tasks;
        this.inflater = LayoutInflater.from(context);

    }
    @Override
    public HomeWork_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.homework_task, parent, false);
        return new HomeWork_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeWork_Adapter.ViewHolder holder, int position) {
        HomeWorkTask task = tasks.get(position);
        holder.nameView.setText(task.getName());
        holder.dataView.setText(task.getData());
        System.out.println(task.getName());

    }



    @Override
    public int getItemCount() {
        System.out.println(tasks.size());
        return tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        final TextView dataView;
        ViewHolder(View view){
            super(view);
            dataView = view.findViewById(R.id.data);
            nameView = view.findViewById(R.id.task);

        }
    }
}
