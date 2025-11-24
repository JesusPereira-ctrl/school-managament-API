package com.colegio.gestion_clases.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.colegio.gestion_clases.exceptions.ResourceNotFoundException;
import com.colegio.gestion_clases.models.dtos.request.StudentRequest;
import com.colegio.gestion_clases.models.dtos.response.StudentResponse;
import com.colegio.gestion_clases.models.entities.Student;
import com.colegio.gestion_clases.repositories.StudentRepository;
import com.colegio.gestion_clases.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentResponse> getAll() {
        return studentRepository.findAll()
                                .stream()
                                .map(StudentResponse::new)
                                .toList();
    }

    @Override
    public StudentResponse getById(Long id) {
        Student studentDB = studentRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        return new StudentResponse(studentDB);
    }

    @Override
    public StudentResponse create(StudentRequest studentRequest) {
        Student studentNew = new Student();

        studentNew.setName(studentRequest.getName());
        studentNew.setLastname(studentRequest.getLastname());
        studentNew.setRut(studentRequest.getRut());

        studentRepository.save(studentNew);

        return new StudentResponse(studentNew);
    }

    @Override
    public StudentResponse update(Long id, StudentRequest studentRequest) {
        Student studentDB = studentRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        studentDB.setName(studentRequest.getName());
        studentDB.setLastname(studentRequest.getLastname());
        studentDB.setRut(studentRequest.getRut());

        studentRepository.save(studentDB);
        
        return new StudentResponse(studentDB);
    }

    @Override
    public void deleteById(Long id) {
        Student studentDB = studentRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        studentRepository.delete(studentDB);
    }

    @Override
    public StudentResponse updateActive(Long id, boolean active) {
        Student studentDB = studentRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        studentDB.setActive(active);
        studentRepository.save(studentDB);

        return new StudentResponse(studentDB);
    }
}
