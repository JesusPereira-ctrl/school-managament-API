package com.colegio.gestion_clases.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.colegio.gestion_clases.exceptions.ResourceNotFoundException;
import com.colegio.gestion_clases.models.dtos.request.NoteRequest;
import com.colegio.gestion_clases.models.dtos.response.note.NoteDetailResponse;
import com.colegio.gestion_clases.models.dtos.response.note.NoteSummaryResponse;
import com.colegio.gestion_clases.models.entities.Note;
import com.colegio.gestion_clases.models.entities.SchoolClass;
import com.colegio.gestion_clases.models.entities.Student;
import com.colegio.gestion_clases.repositories.NoteRepository;
import com.colegio.gestion_clases.repositories.SchoolClassRepository;
import com.colegio.gestion_clases.repositories.StudentRepository;
import com.colegio.gestion_clases.services.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;

    public NoteServiceImpl(NoteRepository noteRepository, StudentRepository studentRepository, SchoolClassRepository schoolClassRepository) {
        this.noteRepository = noteRepository;
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    @Override
    public List<NoteSummaryResponse> getAll() {
        return noteRepository.findAll()
                             .stream()
                             .map(NoteSummaryResponse::new)
                             .toList();
    }

    @Override
    public NoteDetailResponse getById(Long id) {
        Note noteDB = noteRepository.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        return new NoteDetailResponse(noteDB);
    }

    @Override
    public NoteDetailResponse create(NoteRequest noteRequest) {
        Note noteNew = new Note();

        noteNew.setValue(noteRequest.getValue());
        noteNew.setType(noteRequest.getType());
        noteNew.setDate(noteRequest.getDate());
        noteNew.setObservation(noteRequest.getObservation());

        Student studentDB = studentRepository.findById(noteRequest.getStudentId())
                                             .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        SchoolClass schoolClassDB = schoolClassRepository.findById(noteRequest.getSchoolClassId())
                                                         .orElseThrow(() -> new ResourceNotFoundException("school_class not found"));

        noteNew.setStudent(studentDB);
        noteNew.setSchoolClass(schoolClassDB);

        noteRepository.save(noteNew);

        return new NoteDetailResponse(noteNew);
    }

    // Razonamiento, si el id que me pasa el usuario en las relaciones es igual al que
    // ya tengo en la DB es absurdo crear peticiones inecesarias para obtener el mismo id
    // esto provocaria carga inecesaria a la API
    @Override
    public NoteDetailResponse update(Long id, NoteRequest noteRequest) {
        Note noteDB = noteRepository.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        noteDB.setValue(noteRequest.getValue());
        noteDB.setType(noteRequest.getType());
        noteDB.setDate(noteRequest.getDate());
        noteDB.setObservation(noteRequest.getObservation());

        // Si el id de la DB de estudiante no es igual al que me pasa por requestBody, entonces abro conexion
        if (!noteDB.getStudent().getId().equals(noteRequest.getStudentId())) {
            Student studentDB = studentRepository.findById(noteRequest.getStudentId())
                                             .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

            noteDB.setStudent(studentDB);
        }

        if (!noteDB.getSchoolClass().getId().equals(noteRequest.getSchoolClassId())) {
            SchoolClass schoolClassDB = schoolClassRepository.findById(noteRequest.getSchoolClassId())
                                                         .orElseThrow(() -> new ResourceNotFoundException("school_class not found"));

            noteDB.setSchoolClass(schoolClassDB);
        }

        noteRepository.save(noteDB);

        return new NoteDetailResponse(noteDB);
    }

    @Override
    public void deleteById(Long id) {
        Note noteDB = noteRepository.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        noteRepository.delete(noteDB);
    }
}
