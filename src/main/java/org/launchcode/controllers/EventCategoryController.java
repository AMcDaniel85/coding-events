package org.launchcode.controllers;

import org.launchcode.data.EventCategoryRepository;
import org.launchcode.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/index";
    }

    @GetMapping("create")
    public String renderCreateEventCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute("eventCategory", new EventCategory());
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/create";
    }

    @PostMapping("create")
    public String processCreateEventCategoryForm(@Valid EventCategory newCategory,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            return "eventCategories/create";
        }

        eventCategoryRepository.save(newCategory);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteCategoryForm(Model model) {
        model.addAttribute("title", "Delete Category");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/delete";
    }

    @PostMapping("delete")
    public String processDeleteCategoryForm(@RequestParam(required = false) int[] categoryID) {

        if (categoryID != null) {
            for (int id : categoryID) {
                eventCategoryRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
}
