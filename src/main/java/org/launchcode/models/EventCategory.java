package org.launchcode.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class EventCategory extends AbstractEntity {

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

    @Override
    public String toString() {
        return name;
    }
}
