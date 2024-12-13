package acc.br.DesafioQUATRO.config;

import acc.br.DesafioQUATRO.beans.DataLoader;
import acc.br.DesafioQUATRO.repository.StudentRepository;
import acc.br.DesafioQUATRO.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private final StudentRepository studentRepository;
    private CepService cepService;

    @Autowired
    public DataInitializer(StudentRepository studentRepository, CepService cepService) {
        this.studentRepository = studentRepository;
        this.cepService = cepService;
    }

    @Bean(initMethod = "initDatabase")
    public DataLoader dataLoader() {
        return new DataLoader(studentRepository, cepService);
    }


}
