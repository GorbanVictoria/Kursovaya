package com.example.kursovaya;

public class To_Do_OneTask {
    private String name;
    private String data;

    public To_Do_OneTask(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(String data) {
        this.data = data;
    }
}
