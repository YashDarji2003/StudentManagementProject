package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired 
	StudentRepo sr;
	
	List<Student> getAll()
	{
		return sr.findAll();
    }
	
	Student saveStudent(Student s)
	{
		return sr.save(s);
	}
	
	Student find(int id)
	{
		return sr.findById(id).orElse(null);
	}
	
	void delete(int id)
	{
		sr.deleteById(id);
	}
}
