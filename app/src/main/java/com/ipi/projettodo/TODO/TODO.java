package com.ipi.projettodo.TODO;

import java.io.Serializable;

public class TODO implements Serializable  {

    private int id;
    private String name;
    private String urgency;

    public TODO()  {
    }

    public TODO(String name, String urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    public TODO(int id, String name, String urgency) {
        this.id = id;
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
}
