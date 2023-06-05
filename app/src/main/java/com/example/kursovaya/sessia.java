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
 * Use the {@link sessia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sessia extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Sessia_task> ses = new ArrayList<>();
    ImageButton create_new_task;
    Dialog dialog;
    public sessia() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sessia.
     */
    // TODO: Rename and change types and number of parameters
    public static sessia newInstance(String param1, String param2) {
        sessia fragment = new sessia();
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
        View view5 = inflater.inflate(R.layout.fragment_sessia, container, false);
        // Inflate the layout for this fragment

        dialog = new Dialog(getContext());
        create_new_task = view5.findViewById(R.id.new_task_ses);
        create_new_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreatingNewTask();
            }
        });

        RecyclerView recyclerView = view5.findViewById(R.id.list);
        ses.add(new Sessia_task("name", "form","data","room"));
        // создаем адаптер
        Sessia_Adapter adapter = new Sessia_Adapter(getContext(), ses);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        ImageButton menu = view5.findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.menu);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button main = dialog.findViewById(R.id.main);
                Button disciplins = dialog.findViewById(R.id.disciplins);
                Button profile = dialog.findViewById(R.id.profile);
                Button lists = dialog.findViewById(R.id.lists);
                Button sessia = dialog.findViewById(R.id.sessia);
                disciplins.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view5).navigate(R.id.action_sessia2_to_disciplines);
                        dialog.cancel();
                    }
                });
                lists.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view5).navigate(R.id.action_sessia2_to_task_Lists);
                        dialog.cancel();
                    }
                });
                main.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view5).navigate(R.id.action_sessia2_to_mainScreen);
                        dialog.cancel();
                    }
                });
                profile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view5).navigate(R.id.action_sessia2_to_profile2);
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        return view5;
    }
    private void showCreatingNewTask() {
        dialog.setContentView(R.layout.dialog_new_sessia);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        EditText task_name, format, data, room;
        task_name = dialog.findViewById(R.id.task_name);
        format = dialog.findViewById(R.id.format);
        data = dialog.findViewById(R.id.dead);
        room = dialog.findViewById(R.id.room);
        Button add = dialog.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_in = String.valueOf(task_name.getText());
                String data_in = String.valueOf(data.getText());
                String format_in = String.valueOf(format.getText());
                String room_in = String.valueOf(room.getText());
                Toast.makeText(getContext(), name_in, Toast.LENGTH_SHORT);
                ses.add(new Sessia_task(name_in, data_in, room_in, format_in));
                dialog.cancel();

            }
        });

        dialog.show();
    }
}
