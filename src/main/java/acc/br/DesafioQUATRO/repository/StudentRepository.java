package acc.br.DesafioQUATRO.repository;

import acc.br.DesafioQUATRO.repository.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);
}
