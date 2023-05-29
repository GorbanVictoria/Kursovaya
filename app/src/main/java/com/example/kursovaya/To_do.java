package com.example.kursovaya;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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
 * Use the {@link To_do#newInstance} factory method to
 * create an instance of this fragment.
 */
public class To_do extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<To_Do_OneTask> tasks = new ArrayList<To_Do_OneTask>();
    ImageButton create_new_task;
    public To_do() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment To_do.
     */
    // TODO: Rename and change types and number of parameters
    public static To_do newInstance(String param1, String param2) {
        To_do fragment = new To_do();
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
       View view4 =inflater.inflate(R.layout.fragment_to_do, container, false);

        TextView view = view4.findViewById(R.id.name_of_list);
        String name = getArguments().getString("name");
        view.setText(name);





        tasks = (ArrayList<To_Do_OneTask>) getArguments().getSerializable("array");



        RecyclerView recyclerView = view4.findViewById(R.id.to_do_list);
// создаем адаптер
        To_Do_Adapter adapter = new To_Do_Adapter(getContext(), tasks);

        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        dialog = new Dialog(getContext());
        create_new_task = view4.findViewById(R.id.new_task);
        create_new_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreatingNewTask();
            }
        });


        return view4;
    }

    private void setInitialData() {


    }

    // обновление текстового поля
    public void setSelectedItem(List_Task selectedItem) {

    }
    Dialog dialog;
    private void showCreatingNewTask() {
        dialog.setContentView(R.layout.dialog_new_to_do);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        EditText task_name, data;
        task_name = dialog.findViewById(R.id.task_name);
        data = dialog.findViewById(R.id.dead);
        Button add = dialog.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_in = String.valueOf(task_name.getText());
                String data_in = String.valueOf(data.getText());
                Toast.makeText(getContext(), name_in, Toast.LENGTH_SHORT);
                tasks.add(new To_Do_OneTask(name_in,data_in));
                System.out.println(name_in);
                dialog.cancel();
                setInitialData();
            }
        });

        dialog.show();
    }
}