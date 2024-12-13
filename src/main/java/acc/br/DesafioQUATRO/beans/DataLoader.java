package acc.br.DesafioQUATRO.beans;

import acc.br.DesafioQUATRO.repository.StudentRepository;
import acc.br.DesafioQUATRO.repository.entities.Student;
import acc.br.DesafioQUATRO.service.CepService;

import java.time.LocalDate;

public class DataLoader {

    private StudentRepository studentRepository;
    private CepService cepService;

    public DataLoader(StudentRepository studentRepository, CepService cepService) {
        this.studentRepository = studentRepository;
        this.cepService = cepService;
    }

    public void initDatabase() {
        if (studentRepository.count() == 0) {
            studentRepository.save(Student.builder()
                    .name("João Silva")
                    .birthDate(LocalDate.of(1995, 5, 20))
                    .adress(cepService.findAdressByCep("01001000"))
                    .course("Computação")
                    .build());
            studentRepository.save(Student.builder()
                    .name("Maria Oliveira")
                    .birthDate(LocalDate.of(1998, 8, 15))
                    .adress(cepService.findAdressByCep("01002000"))
                    .course("Matemática")
                    .build());

            System.out.println("Banco de dados inicializado com estudantes.");
        } else {
            System.out.println("O banco de dados já contém dados. Nenhuma ação realizada.");
        }
    }
}
