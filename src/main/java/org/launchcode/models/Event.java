package org.launchcode.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextID = 1;
    @NotBlank(message = "Name is required.")
    @Size(min=3,max=50, message = "Name must be between 3 and 50 characters.")
    private String name;
    @Size(max=500, message = "Description too long")
    private String description;
    @NotBlank
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    @NotBlank(message = "Must enter location.")
    private String location;
    @NotNull
    private double price;
    private EventType type;
    @AssertTrue
    private Boolean mustRegister;
    @Min(1)
    private double numAttendees;

    public Event(){
        this.id = nextID;
        nextID++;
    }

    public Event(String name, String description, String contactEmail, Date date, String location, double price, EventType type,
                 Boolean mustRegister, double numAttendees) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.date = date;
        this.location = location;
        this.price = price;
        this.type = type;
        this.mustRegister = true;
        this.numAttendees = numAttendees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Boolean getMustRegister() {
        return mustRegister;
    }

    public void setMustRegister(Boolean mustRegister) {
        this.mustRegister = mustRegister;
    }

    public double getNumAttendees() {
        return numAttendees;
    }

    public void setNumAttendees(double numAttendees) {
        this.numAttendees = numAttendees;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
