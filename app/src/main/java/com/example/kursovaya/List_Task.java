package com.example.kursovaya;

import java.util.ArrayList;

public class List_Task {
    private String name;

    private ArrayList<To_Do_OneTask> tasks = new ArrayList<To_Do_OneTask>();
    public List_Task(String name){

        this.name=name;

    }

    public ArrayList<To_Do_OneTask> getTasks() {
        return tasks;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add_el(String name, String data){
        To_Do_OneTask task = new To_Do_OneTask(name,data);
        tasks.add(task);
    }
}
