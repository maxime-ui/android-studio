package com.ipi.android_todo.Package;

public class POJO {




    private int id;
    private String name;
    private String urgency;

    public POJO() {
    }

    public POJO(String name, String urgency) {
        this.name = name;
        this.urgency = urgency;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return "POJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urgency='" + urgency + '\'' +
                '}';
    }
}
