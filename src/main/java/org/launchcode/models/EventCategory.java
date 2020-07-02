package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class EventCategory {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Name is required")
    private String name;

    public EventCategory(String name) {
        this.name = name;
    }

    public EventCategory(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
