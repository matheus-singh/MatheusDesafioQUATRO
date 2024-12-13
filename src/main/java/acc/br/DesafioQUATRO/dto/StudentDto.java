package acc.br.DesafioQUATRO.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private String name;
    private LocalDate birthDate;
    private String uf;
    private String city;
    private String street;
    private String cep;
    private String course;
}
