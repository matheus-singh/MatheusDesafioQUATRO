package acc.br.DesafioQUATRO.controller;

import acc.br.DesafioQUATRO.controller.requests.UserRegistrationRequest;
import acc.br.DesafioQUATRO.repository.UserRepository;
import acc.br.DesafioQUATRO.repository.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRegisterUserSuccess() throws Exception {

        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("username", "matheus")
                        .param("password", "senha")
                        .param("role", "USER")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection());

        // Verifica se o usuário foi criado no banco de dados
        User user = userRepository.findByUsername("matheus");
        assert user != null;
        assert user.getUsername().equals("matheus");
        assert user.getRole().equals("USER");
    }
}