package acc.br.DesafioQUATRO.service;

import acc.br.DesafioQUATRO.controller.requests.StudentRegistrationRequest;
import acc.br.DesafioQUATRO.dto.StudentDto;
import acc.br.DesafioQUATRO.repository.entities.Student;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAllStudents();

    Student save(Student student);

    StudentDto createAndSave(StudentRegistrationRequest studentRegistrationRequest);

    StudentDto createAndSave(StudentDto studentDto);

    void deleteByName(String name);
}
