package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Students;
import com.app.repository.StudentsRepository;

@Service
public class StudentService {

	@Autowired
	StudentsRepository repository;

	public Students getStudent(Integer id) {
		Optional<Students> student = repository.findById(id);
		return student.get();
	}

	public List<Students> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
