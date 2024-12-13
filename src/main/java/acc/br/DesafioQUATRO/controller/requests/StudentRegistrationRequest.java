package acc.br.DesafioQUATRO.controller.requests;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRegistrationRequest {
    private String name;
    private LocalDate birthDate;

    @Pattern(regexp = "\\d{8}", message = "CEP inválido.")
    private String cep;
    private String course;
}
