package com.colegio.gestion_clases.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.colegio.gestion_clases.exceptions.ResourceNotFoundException;
import com.colegio.gestion_clases.models.dtos.request.TeacherRequest;
import com.colegio.gestion_clases.models.dtos.response.TeacherResponse;
import com.colegio.gestion_clases.models.entities.Teacher;
import com.colegio.gestion_clases.repositories.TeacherRepository;
import com.colegio.gestion_clases.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherResponse> getAll() {
        return teacherRepository.findAll()
                                .stream()
                                .map(TeacherResponse::new)
                                .toList();
    }

    @Override
    public TeacherResponse getById(Long id) {
        Teacher teacherDB = teacherRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        return new TeacherResponse(teacherDB);
    }

    @Override
    public TeacherResponse create(TeacherRequest teacherRequest) {
        Teacher teacherNew = new Teacher();
        teacherNew.setName(teacherRequest.getName());
        teacherNew.setLastname(teacherRequest.getLastname());
        teacherNew.setRut(teacherRequest.getRut());
        teacherNew.setEmail(teacherRequest.getEmail());
        teacherNew.setPhone(teacherRequest.getPhone());

        teacherRepository.save(teacherNew);

        return new TeacherResponse(teacherNew);
    }

    @Override
    public TeacherResponse update(Long id, TeacherRequest teacherRequest) {
        Teacher teacherDB = teacherRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        teacherDB.setName(teacherRequest.getName());
        teacherDB.setLastname(teacherRequest.getLastname());
        teacherDB.setRut(teacherRequest.getRut());
        teacherDB.setEmail(teacherRequest.getEmail());
        teacherDB.setPhone(teacherRequest.getPhone());

        teacherRepository.save(teacherDB);

        return new TeacherResponse(teacherDB);
    }

    @Override
    public void deleteById(Long id) {
        Teacher teacherDB = teacherRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        teacherRepository.delete(teacherDB);
    }

    @Override
    public TeacherResponse updateActive(Long id, boolean active) {
        Teacher teacherDB = teacherRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        teacherDB.setActive(active);
        teacherRepository.save(teacherDB);

        return new TeacherResponse(teacherDB);
    }
}
