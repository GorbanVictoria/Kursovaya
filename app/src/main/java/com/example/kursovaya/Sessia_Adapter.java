package com.example.kursovaya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Sessia_Adapter extends RecyclerView.Adapter<Sessia_Adapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<Sessia_task> tasks;

//lll

    interface OnTaskClickListener{
        void onTaskClick(List_Task task, int position);
    }

    Sessia_Adapter(Context context, List<Sessia_task> states) {
        this.tasks = states;
        this.inflater = LayoutInflater.from(context);

    }
    @Override
    public Sessia_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.sessia_task, parent, false);
        return new Sessia_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Sessia_Adapter.ViewHolder holder, int position) {
        Sessia_task state = tasks.get(position);
        holder.nameView.setText(state.getName());
        holder.dataView.setText(state.getData());
        holder.formatView.setText(state.getForm());
        holder.roomView.setText(state.getRoom());


    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView nameView, dataView, roomView, formatView;
        ViewHolder(View view){
            super(view);

            nameView = view.findViewById(R.id.task);
            dataView = view.findViewById(R.id.data);
            roomView = view.findViewById(R.id.room);
            formatView = view.findViewById(R.id.format);
        }
    }
}
