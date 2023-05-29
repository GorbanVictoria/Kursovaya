package com.example.kursovaya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class To_Do_Adapter extends RecyclerView.Adapter<To_Do_Adapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<To_Do_OneTask> tasks;


    interface OnTaskClickListener{
        void onTaskClick(To_Do_OneTask task, int position);
    }
    private final OnTaskClickListener onClickListener;
    To_Do_Adapter(Context context, List<To_Do_OneTask> states, OnTaskClickListener onClickListener) {
        this.tasks = states;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }
    @Override
    public To_Do_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.to_do_item, parent, false);
        return new To_Do_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(To_Do_Adapter.ViewHolder holder, int position) {
        To_Do_OneTask state = tasks.get(position);
        holder.nameView.setText(state.getName());
        holder.dataView.setText(state.getData());
        System.out.println(state.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                // вызываем метод слушателя, передавая ему данные
                onClickListener.onTaskClick(state, position);
            }
        });
    }

//    @Override
//    public void onBindViewHolder(Task_Adapter.ViewHolder holder, int position) {
//        To_Do_OneTask state = tasks.get(position);
//        holder.nameView.setText(state.getName());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v)
//            {
//                // вызываем метод слушателя, передавая ему данные
//                onClickListener.onTaskClick(state, position);
//            }
//        });
//
//    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView nameView, dataView;
        ViewHolder(View view){
            super(view);
            dataView = view.findViewById(R.id.text_data);
            nameView = view.findViewById(R.id.text_name);

        }
    }
}
