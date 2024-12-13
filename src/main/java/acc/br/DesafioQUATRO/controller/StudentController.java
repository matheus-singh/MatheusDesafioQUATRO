package acc.br.DesafioQUATRO.controller;

import acc.br.DesafioQUATRO.controller.requests.StudentRegistrationRequest;
import acc.br.DesafioQUATRO.dto.StudentDto;
import acc.br.DesafioQUATRO.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@PreAuthorize("hasAnyRole('USER', 'ADMIN')") // Restringe acesso a usuários autenticados com as roles USER ou ADMIN
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    // Exibe o formulário de cadastro
    @GetMapping("/students/register")
    public ModelAndView RegisterStudent(){
        StudentRegistrationRequest studentRegistrationRequest = new StudentRegistrationRequest();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentsRegistration");
        modelAndView.addObject("studentRegistrationRequest", studentRegistrationRequest);
        return modelAndView;
    }

    // Recebe os dados do formulário e processa a confirmação
    @PostMapping("/students/register")
    public ModelAndView registerStudent(@ModelAttribute("studentRegistrationRequest") StudentRegistrationRequest studentRegistrationRequest) {

        // Com os dados recebidos retorna um DTO para confirmacao
        StudentDto student = studentService.createAndSave(studentRegistrationRequest);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentsConfirmation"); // tela de confirmacao
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    // cancelamento
    @GetMapping("/cancel")
    public String cancelRegistration() {
        return "redirect:/home";  // página inicial de estudantes
    }

    // confirma
    @PostMapping("/students/register/confirm")
    public String confirmStudentRegistration(@ModelAttribute("student") StudentDto studentDto){
        // Com o DTO cria e salva o estudante
        studentService.createAndSave(studentDto);
        return "redirect:/home";
    }
}
