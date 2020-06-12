package org.launchcode.controllers;

import org.launchcode.data.EventData;
import org.launchcode.models.Event;
import org.launchcode.models.EventType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;


@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String renderEventForm(Model model){
        model.addAttribute("title", "Create Event");
        model.addAttribute("event", new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model){
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String deleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEvent(@RequestParam(required = false) int[] eventIds){
        if(eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        Event event = EventData.getByID(eventId);
        String name = event.getName();
        int iD = event.getId();
        model.addAttribute("title", "Edit Event: Name = " + name + " ID = " + iD);
        model.addAttribute("event", event);
        return "events/edit";
    }

    @PostMapping("edit/{eventId}")
    public String processEditForm(int eventId, String name, String description, Date date, String location, double price,
                                  Boolean mustRegister, double numAttendees) {
        Event event = EventData.getByID(eventId);
        event.setName(name);
        event.setDescription(description);
        event.setDate(date);
        event.setLocation(location);
        event.setPrice(price);
        event.setNumAttendees(numAttendees);
        event.setMustRegister(true);
        return "";
    }

}
