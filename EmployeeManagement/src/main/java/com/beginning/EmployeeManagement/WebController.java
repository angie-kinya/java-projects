package com.beginning.EmployeeManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class WebController {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public String viewEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("newEmployee", new Employee());
        return "employees";
    }

    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }
    
}
