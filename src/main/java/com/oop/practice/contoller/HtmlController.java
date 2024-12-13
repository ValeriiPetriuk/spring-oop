package com.oop.practice.contoller;


import com.oop.practice.dto.InspectionDTO;
import com.oop.practice.dto.LoginDTO;
import com.oop.practice.entity.Inspection;
import com.oop.practice.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HtmlController {

    @Autowired
    private InspectionService inspectionService;


    @GetMapping("/admin")
    public String adminPanel(Model model){
        Map<String, List<Inspection>> inspectionsByDay = inspectionService.getWeekdayInspections();
        model.addAttribute("inspections", inspectionsByDay);;
        return "admin";
    }

    @GetMapping("/admin/add")
    public String addForm(Model model) {
        model.addAttribute("inspection", new InspectionDTO());
        return "inspection-form";
    }

    @PostMapping("admin/save")
    public String saveInspection(@ModelAttribute InspectionDTO inspection) {
        inspectionService.save(inspectionService.convertToEntity(inspection));
        return "redirect:/admin";
    }

    @GetMapping("admin/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("inspection", inspectionService.getInspectionById(id));
        return "inspection-form";
    }

    @GetMapping("admin/delete/{id}")
    public String deleteInspection(@PathVariable int id) {
        inspectionService.deleteInspection(id);
        return "redirect:/admin";
    }
    @GetMapping
    public String getWeeklySchedule(Model model){
        Map<String, List<Inspection>> inspectionsByDay = inspectionService.getWeekdayInspections();
        model.addAttribute("schedule", inspectionsByDay);
        return "schedule";
    }
}
