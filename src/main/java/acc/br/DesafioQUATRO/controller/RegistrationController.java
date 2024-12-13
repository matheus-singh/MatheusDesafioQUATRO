package acc.br.DesafioQUATRO.controller;

import acc.br.DesafioQUATRO.controller.requests.UserRegistrationRequest;
import acc.br.DesafioQUATRO.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("userRegistrationRequest", new UserRegistrationRequest());
        return modelAndView;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userRegistrationRequest") UserRegistrationRequest userRegistrationRequest) {
        userService.registerUser(userRegistrationRequest);
        return "redirect:/login";
    }
}