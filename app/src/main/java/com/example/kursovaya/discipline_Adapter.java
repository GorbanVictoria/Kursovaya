package com.example.kursovaya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class discipline_Adapter extends RecyclerView.Adapter<discipline_Adapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<discipline_task> tasks;

//lll

    interface OnTaskClickListener{
        void onTaskClick(discipline_task task, int position);
    }
    private final discipline_Adapter.OnTaskClickListener onClickListener;

    discipline_Adapter(Context context, List<discipline_task> states, discipline_Adapter.OnTaskClickListener onClickListener) {
        this.tasks = states;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }
    @Override
    public discipline_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.discipline_item, parent, false);
        return new discipline_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(discipline_Adapter.ViewHolder holder, int position) {
        discipline_task state = tasks.get(position);
        holder.nameView.setText(state.getName());
        holder.roomView.setText(state.getRoom());
        holder.dataView.setText(state.getFormat());

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

        final TextView nameView, dataView, roomView;
        ViewHolder(View view){
            super(view);
            dataView = view.findViewById(R.id.data);
            roomView = view.findViewById(R.id.room);
            nameView = view.findViewById(R.id.task);

        }
    }
}
