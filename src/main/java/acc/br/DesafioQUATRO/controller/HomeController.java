package acc.br.DesafioQUATRO.controller;

import acc.br.DesafioQUATRO.dto.StudentDto;
import acc.br.DesafioQUATRO.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller for handling home and login routes.
 */
@Controller
public class HomeController {

    /**
     * Handle GET requests to /home.
     * @return View name for home page
     */

    private StudentService studentService;

    @Autowired
    public HomeController(StudentService studentService){
        this.studentService = studentService;
    }

    // Lista os estudantes cadastrados na pagina principal
    @GetMapping("/home")
    public ModelAndView home(){
        List<StudentDto> students = studentService.findAllStudents();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}