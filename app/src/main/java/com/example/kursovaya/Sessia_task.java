package com.example.kursovaya;

public class Sessia_task {
    private String name, form, data, room;

    public Sessia_task(String name, String form, String data, String room) {
        this.name = name;
        this.form = form;
        this.data = data;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
