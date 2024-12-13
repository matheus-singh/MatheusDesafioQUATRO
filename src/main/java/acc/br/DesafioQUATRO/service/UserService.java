package acc.br.DesafioQUATRO.service;

import acc.br.DesafioQUATRO.controller.requests.UserRegistrationRequest;
import acc.br.DesafioQUATRO.repository.entities.User;

public interface UserService {
    User registerUser(UserRegistrationRequest userRegistrationRequest);
}