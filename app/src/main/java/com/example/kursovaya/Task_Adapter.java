package com.example.kursovaya;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class Task_Adapter extends RecyclerView.Adapter<Task_Adapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<List_Task> tasks;

//lll

    interface OnTaskClickListener{
        void onTaskClick(List_Task task, int position);
    }
    private final OnTaskClickListener onClickListener;
    Task_Adapter(Context context, List<List_Task> states,OnTaskClickListener onClickListener) {
        this.tasks = states;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }
    @Override
    public Task_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_list_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Task_Adapter.ViewHolder holder, int position) {
        List_Task state = tasks.get(position);
        holder.nameView.setText(state.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                // вызываем метод слушателя, передавая ему данные
                onClickListener.onTaskClick(state, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView nameView;
        ViewHolder(View view){
            super(view);

            nameView = view.findViewById(R.id.task);

        }
    }
}
