package com.example.kursovaya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class To_Do_Adapter extends RecyclerView.Adapter<To_Do_Adapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final ArrayList<To_Do_OneTask> tasks;




    To_Do_Adapter(Context context, ArrayList<To_Do_OneTask> tasks) {
        this.tasks = tasks;
        this.inflater = LayoutInflater.from(context);

    }
    @Override
    public To_Do_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.to_do_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(To_Do_Adapter.ViewHolder holder, int position) {
        To_Do_OneTask task = tasks.get(position);
        holder.nameView.setText(task.getName());
        holder.dataView.setText(task.getData());
        System.out.println(task.getName());

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
        System.out.println(tasks.size());
        return tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final CheckBox nameView;
        final TextView dataView;
        ViewHolder(View view){
            super(view);
            dataView = view.findViewById(R.id.text_data);
            nameView = view.findViewById(R.id.text_name);

        }
    }
}
