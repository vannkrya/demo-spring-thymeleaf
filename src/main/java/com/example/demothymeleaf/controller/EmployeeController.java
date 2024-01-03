package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.model.Employee;
import com.example.demothymeleaf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelAndView modelAndView;

    //use Model to return html page
    @GetMapping("/test")
    public String getTest(Model model) {
        String name = "Krya";
        model.addAttribute("empName", name);
        return "hello"; //find at templates folder, return hello.html
    }


    //use ModelAndView to return html page
    @GetMapping("/test1")
    public ModelAndView getTest1() {
        String name = "Krya ModelAndView";
        modelAndView.addObject("empNameMV", name);
        modelAndView.setViewName("hello"); //hello.html file
        return modelAndView;
    }


    @GetMapping("/employees")
    public ModelAndView getAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        modelAndView.addObject("empList", employeeList);
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @GetMapping("/add-employee-form")
    public ModelAndView getAddEmployeeForm() {
        modelAndView.addObject("emp", new Employee());
        modelAndView.setViewName("/pages/add-emp-form");
        return modelAndView;
    }


    @PostMapping("/add-employee")
    public ModelAndView addEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        modelAndView.setViewName("redirect:/employees");
        return modelAndView;
    }


    @GetMapping("/edit-employee-form{id}")
    public ModelAndView getEditEmployeeForm(@PathVariable Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        modelAndView.addObject("emp", employee);
        modelAndView.setViewName("/pages/edit-emp-form");
        return modelAndView;
    }


    @PostMapping("/edit-employee/{id}")
    public ModelAndView editEmployee(@ModelAttribute Employee employee, @PathVariable Integer id) {
        employeeService.editEmployee(employee, id);
        modelAndView.setViewName("redirect:/employees");
        return modelAndView;
    }


    @PostMapping("/delete-employee/{id}")
    public ModelAndView deleteEmployee(@PathVariable Integer id) {
         employeeService.deleteEmployee(id);
         modelAndView.setViewName("redirect:/employees");
         return modelAndView;
    }

}
