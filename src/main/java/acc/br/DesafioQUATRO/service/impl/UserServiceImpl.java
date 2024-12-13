package acc.br.DesafioQUATRO.service.impl;

import acc.br.DesafioQUATRO.controller.requests.UserRegistrationRequest;
import acc.br.DesafioQUATRO.repository.UserRepository;
import acc.br.DesafioQUATRO.repository.entities.User;
import acc.br.DesafioQUATRO.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(UserRegistrationRequest userRegistrationRequest) {
        User user = User.builder()
                .username(userRegistrationRequest.getUsername())
                .password(passwordEncoder.encode(userRegistrationRequest.getPassword()))
                .role(userRegistrationRequest.getRole())
                .build();
        return userRepository.save(user);
    }
}