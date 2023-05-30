package com.example.kursovaya;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link disciplines#newInstance} factory method to
 * create an instance of this fragment.
 */
public class disciplines extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    ArrayList<discipline_task> states = new ArrayList<discipline_task>();
    Dialog dialog;
    ImageButton create_new_task;
    public disciplines() {
        // Required empty public constructor
    }


    public static disciplines newInstance(String param1, String param2) {
        disciplines fragment = new disciplines();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view6 = inflater.inflate(R.layout.fragment_disciplines, container, false);
        // Inflate the layout for this fragment

        RecyclerView recyclerView = view6.findViewById(R.id.list);
        states.add(new discipline_task("name","room","format"));
        discipline_Adapter.OnTaskClickListener taskClickListener = new discipline_Adapter.OnTaskClickListener() {
            @Override
            public void onTaskClick(discipline_task state, int position) {
                Bundle bundle = new Bundle();
                String name = state.getName();
                bundle.putString("name",name);
                System.out.println(name);
                Navigation.findNavController(view6).navigate(R.id.action_disciplines_to_homeWork, bundle);
                Toast.makeText(getContext(), "Был выбран пункт " + position,
                        Toast.LENGTH_SHORT).show();
            }
        };
        // создаем адаптер
        discipline_Adapter adapter = new discipline_Adapter(getContext(), states, taskClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        dialog = new Dialog(getContext());
        create_new_task = view6.findViewById(R.id.new_task_ses);
        create_new_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreatingNewTask();
            }
        });


        return view6;
    }

    private void showCreatingNewTask() {
        dialog.setContentView(R.layout.dialog_new_discipline);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        EditText task_name, room, format;
        task_name = dialog.findViewById(R.id.task_name);
        room = dialog.findViewById(R.id.room);
        format = dialog.findViewById(R.id.format);
        Button add = dialog.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_in = String.valueOf(task_name.getText());
                String room_in = String.valueOf(room.getText());
                String format_in = String.valueOf(format.getText());
                Toast.makeText(getContext(), name_in, Toast.LENGTH_SHORT);
                states.add(new discipline_task(name_in, room_in, format_in));
                dialog.cancel();

            }
        });

        dialog.show();
    }
}