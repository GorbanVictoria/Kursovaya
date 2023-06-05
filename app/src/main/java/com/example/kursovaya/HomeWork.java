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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeWork#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeWork extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<HomeWorkTask> tasks = new ArrayList<HomeWorkTask>();
    Dialog dialog;
    ImageButton create_new_task;

    public HomeWork() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeWork.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeWork newInstance(String param1, String param2) {
        HomeWork fragment = new HomeWork();
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
        View view7 = inflater.inflate(R.layout.fragment_home_work, container, false);

        TextView view = view7.findViewById(R.id.discipline_name);
        String name = getArguments().getString("name");
        System.out.println(name);
        view.setText(name);

        tasks = (ArrayList<HomeWorkTask>) getArguments().getSerializable("array");



        RecyclerView recyclerView = view7.findViewById(R.id.list);
// создаем адаптер
        HomeWork_Adapter adapter = new HomeWork_Adapter(getContext(), tasks);
        recyclerView.setAdapter(adapter);

        dialog = new Dialog(getContext());
        create_new_task = view7.findViewById(R.id.new_task_ses);
        create_new_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreatingNewTask();
            }
        });
        // Inflate the layout for this fragment
        ImageButton menu = view7.findViewById(R.id.menu);
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
                profile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view7).navigate(R.id.action_homeWork_to_profile2);
                        dialog.cancel();
                    }
                });
                disciplins.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view7).navigate(R.id.action_homeWork_to_disciplines);
                        dialog.cancel();
                    }
                });
                lists.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view7).navigate(R.id.action_homeWork_to_task_Lists);
                        dialog.cancel();
                    }
                });
                main.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view7).navigate(R.id.action_homeWork_to_mainScreen);
                        dialog.cancel();
                    }
                });
                sessia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view7).navigate(R.id.action_homeWork_to_sessia2);
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        return view7;
    }
    private void showCreatingNewTask() {
        dialog.setContentView(R.layout.dialog_new_to_do);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        EditText task_name, data;
        task_name = dialog.findViewById(R.id.task_name);
        data = dialog.findViewById(R.id.dead);
        Button add = dialog.findViewById(R.id.add);
        //
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_in = String.valueOf(task_name.getText());
                String data_in = String.valueOf(data.getText());
                Toast.makeText(getContext(), name_in, Toast.LENGTH_SHORT);
                tasks.add(new HomeWorkTask(name_in,data_in));
                System.out.println(name_in);
                dialog.cancel();

            }
        });

        dialog.show();
    }
}