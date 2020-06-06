package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

//    private static List<String> events = new ArrayList<>();
    public HashMap<String, String> events = new HashMap<>();
    String event1 = "Code With Pride";
    String event1des = "LaunchCode meetup for LGBTQ+";
    String event2 = "Code til Dawn";
    String event2des = "STL meetup that runs 7pm to 1am";
    String event3 = "Lecture";
    String event3des = "LC101 lectures via Zoom";
    String address = "4811 Delmar Blvd, St. Louis, MO 63108";



    @GetMapping
    public String displayAllEvents(Model model) {
//        model.addAttribute("title", "All Events");
//        model.addAttribute("events", events);
        events.put(event1, event1des);
        events.put(event2, event2des);
        events.put(event3, event3des);
        model.addAttribute("events", events);
        model.addAttribute("address", address);
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
        events.put(eventName, eventDescription);
        return "redirect:";
    }

}