package com.example.kursovaya;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.CharacterPickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;


public class Task_Lists extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ImageButton create_new_task;
    Button create;
    Dialog dialog;


    ArrayList<List_Task> states = new ArrayList<List_Task>();


    public Task_Lists() {
        // Required empty public constructor
    }


    public static Task_Lists newInstance(String param1, String param2) {
        Task_Lists fragment = new Task_Lists();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view3 = inflater.inflate(R.layout.fragment_task__lists, container, false);
        // Inflate the layout for this fragment



        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = view3.findViewById(R.id.list);

        Task_Adapter.OnTaskClickListener taskClickListener = new Task_Adapter.OnTaskClickListener() {
            @Override
            public void onTaskClick(List_Task state, int position) {
                Bundle bundle = new Bundle();

                String name = state.getName();
                bundle.putString("name",name);

                state.add_el("jjfjf","dkkd");
                ArrayList<To_Do_OneTask> tasks = new ArrayList<To_Do_OneTask>();
                tasks = state.getTasks();

                bundle.putSerializable("array",tasks);

                Navigation.findNavController(view3).navigate(R.id.action_task_Lists_to_to_do, bundle);
                Toast.makeText(getContext(), "Был выбран пункт " + position,
                        Toast.LENGTH_SHORT).show();
            }
        };
        // создаем адаптер
        Task_Adapter adapter = new Task_Adapter(getContext(), states, taskClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        dialog = new Dialog(getContext());
        create_new_task = view3.findViewById(R.id.new_task);
        create_new_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreatingNewTask();
            }
        });

        return view3;
    }

    private void showCreatingNewTask() {
        dialog.setContentView(R.layout.dialog_new_task);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        EditText task_name;
        task_name = dialog.findViewById(R.id.task_name);
        Button add = dialog.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_in = String.valueOf(task_name.getText());
                Toast.makeText(getContext(), name_in, Toast.LENGTH_SHORT);
                states.add(new List_Task(name_in));
                dialog.cancel();
                setInitialData();
            }
        });

        dialog.show();
    }

    private void setInitialData(){


        }



    }
