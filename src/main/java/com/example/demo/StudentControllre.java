package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class StudentControllre {
	
	@Autowired 
	StudentService ss;

	
@GetMapping("/list")
String getData(Model m)
{
	List<Student> l=ss.getAll();	
	m.addAttribute("students",l);
	return "list";
}

@GetMapping("/form")
String showForm(Model m)
{
	Student s=new Student();
	m.addAttribute("stud",s);
	return "form";
}

@PostMapping("/form/save")
String saves(	
		@Valid 	@ModelAttribute("stud") Student s,BindingResult result)
{
    if (result.hasErrors()) {
        return "form"; // Return to form if validation errors
    }
	ss.saveStudent(s);
	return "redirect:/list";
}

@GetMapping("/showUpdateForm")
String UpdateForm(@RequestParam("studentId") int id,Model m)
{
	Student s=ss.find(id);
	m.addAttribute("stud",s);
	return "form";
}

@GetMapping("/deleteStudent")
String delete(@RequestParam("studentId") int id)
{
	ss.delete(id);
	
	return "redirect:/list";
}
}
