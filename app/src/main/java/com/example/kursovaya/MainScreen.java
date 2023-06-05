package com.example.kursovaya;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainScreen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainScreen.
     */
    // TODO: Rename and change types and number of parameters
    public static MainScreen newInstance(String param1, String param2) {
        MainScreen fragment = new MainScreen();
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
        View view2 =inflater.inflate(R.layout.fragment_main_screen, container, false);

        Button b1 = view2.findViewById(R.id.to_tasks);
        Date date = new Date();
        String month = "Ничего";
        int date1 = date.getMonth();
        switch (date1){
            case (0):
                month = "Января";
                break;
            case (11):
                month = "Декабря";
                break;
            case (1):
                month = "Февраля";
                break;
            case (2):
                month = "Марта";
                break;
            case (3):
                month = "Апреля";
                break;
            case (4):
                month = "Мая";
                break;
            case (5):
                month = "Июня";
                break;
            case (6):
                month = "Июля";
                break;
            case (7):
                month = "Августа";
                break;
            case (8):
                month = "Сентября";
                break;
            case (9):
                month = "Октября";
                break;
            case (10):
                month = "Ноября";
                break;

        }
        TextView to_month = view2.findViewById(R.id.Data_month);
        to_month.setText(month);
        int day = date.getDate()+1;
        System.out.println(day);
        TextView to_day = view2.findViewById(R.id.Data_day);
        to_day.setText(Integer.toString(day));
        int day_of_week = date.getDay();
        String week = "Ничего";
        TextView to_week = view2.findViewById(R.id.Day_of_week);
        switch(day_of_week){
            case(6):
                week = "Воскресенье";
            case(0):
                week = "Понедельник";
            case(1):
                week = "Вторник";
            case(2):
                week = "Среда";
            case(3):
                week = "Четверг";
            case(4):
                week = "Пятница";
            case(5):
                week = "Суббота";
        }
        to_week.setText(week);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view2).navigate(R.id.action_mainScreen_to_task_Lists);
            }
        });
        Dialog dialog = new Dialog(getContext());
        ImageButton menu = view2.findViewById(R.id.menu);
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
                        Navigation.findNavController(view2).navigate(R.id.action_mainScreen_to_profile2);
                        dialog.cancel();
                    }
                });
                disciplins.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view2).navigate(R.id.action_mainScreen_to_disciplines);
                        dialog.cancel();
                    }
                });
                lists.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view2).navigate(R.id.action_mainScreen_to_task_Lists);
                        dialog.cancel();
                    }
                });

                sessia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view2).navigate(R.id.action_mainScreen_to_sessia2);
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

        return view2;
    }
}