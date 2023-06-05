package com.example.kursovaya;

import java.util.ArrayList;

public class discipline_task {
    private String name, room, format;


    private ArrayList<HomeWorkTask> tasks = new ArrayList<HomeWorkTask>();

    public discipline_task(String name, String room, String format){
        this.room = room;
        this.format = format;
        this.name=name;

    }

    public ArrayList<HomeWorkTask> getTasks() {
        return tasks;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add_el(String name, String data){
        HomeWorkTask task = new HomeWorkTask(name,data);
        tasks.add(task);
    }
}
