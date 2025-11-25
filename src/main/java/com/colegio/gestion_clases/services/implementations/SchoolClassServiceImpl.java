package com.colegio.gestion_clases.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.colegio.gestion_clases.exceptions.ResourceNotFoundException;
import com.colegio.gestion_clases.models.dtos.request.SchoolClassRequest;
import com.colegio.gestion_clases.models.dtos.response.classes.SchoolClassDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.classes.SchoolClassSummaryResponse;
import com.colegio.gestion_clases.models.entities.SchoolClass;
import com.colegio.gestion_clases.models.entities.Subject;
import com.colegio.gestion_clases.models.entities.Teacher;
import com.colegio.gestion_clases.repositories.SchoolClassRepository;
import com.colegio.gestion_clases.repositories.SubjectRepository;
import com.colegio.gestion_clases.repositories.TeacherRepository;
import com.colegio.gestion_clases.services.SchoolClassService;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;

    private final TeacherRepository teacherRepository;

    private final SubjectRepository subjectRepository;

    public SchoolClassServiceImpl(SchoolClassRepository schoolClassRepository, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.schoolClassRepository = schoolClassRepository;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<SchoolClassSummaryResponse> getAll() {
        return schoolClassRepository.findAll()
                                    .stream()
                                    .map(SchoolClassSummaryResponse::new)
                                    .toList();
    }

    @Override
    public SchoolClassDetailResponse getById(Long id) {
        SchoolClass schoolClassDB = schoolClassRepository.findById(id)
                                                 .orElseThrow(() -> new ResourceNotFoundException("Class not found"));

        return new SchoolClassDetailResponse(schoolClassDB);
    }

    @Override
    public SchoolClassDetailResponse create(SchoolClassRequest schoolClassRequest) {
        SchoolClass schoolClassNew = new SchoolClass();

        schoolClassNew.setCourse(schoolClassRequest.getCourse());
        schoolClassNew.setHall(schoolClassRequest.getHall());
        schoolClassNew.setSchedule(schoolClassRequest.getSchedule());

        Teacher teacherDB = teacherRepository.findById(schoolClassRequest.getTeacherId())
                                             .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        Subject subjectDB = subjectRepository.findById(schoolClassRequest.getSubjectId())
                                             .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        schoolClassNew.setTeacher(teacherDB);
        schoolClassNew.setSubject(subjectDB);

        schoolClassRepository.save(schoolClassNew);

        return new SchoolClassDetailResponse(schoolClassNew);
    }

    @Override
    public SchoolClassDetailResponse update(Long id, SchoolClassRequest schoolClassRequest) {
        SchoolClass schoolClassDB = schoolClassRepository.findById(id)
                                                         .orElseThrow(() -> new ResourceNotFoundException("Class not found"));

        schoolClassDB.setCourse(schoolClassRequest.getCourse());
        schoolClassDB.setHall(schoolClassRequest.getHall());
        schoolClassDB.setSchedule(schoolClassRequest.getSchedule());

        if (!schoolClassDB.getTeacher().getId().equals(schoolClassRequest.getTeacherId())) {
            Teacher teacherDB = teacherRepository.findById(schoolClassRequest.getTeacherId())
                                             .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

            schoolClassDB.setTeacher(teacherDB);
        }

        if (!schoolClassDB.getSubject().getId().equals(schoolClassRequest.getSubjectId())) {
            Subject subjectDB = subjectRepository.findById(schoolClassRequest.getSubjectId())
                                             .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

            schoolClassDB.setSubject(subjectDB);
        }

        schoolClassRepository.save(schoolClassDB);

        return new SchoolClassDetailResponse(schoolClassDB);
    }

    @Override
    public void deleteById(Long id) {
        SchoolClass schoolClassDB = schoolClassRepository.findById(id)
                                                         .orElseThrow(() -> new ResourceNotFoundException("Class not found"));
        
        schoolClassRepository.delete(schoolClassDB);
    } 
}
