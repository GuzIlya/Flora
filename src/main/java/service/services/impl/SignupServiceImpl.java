package service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import service.forms.UserForm;
import service.models.User;
import service.repositories.UsersRepository;
import service.services.SignupService;

@Service
public class SignupServiceImpl implements SignupService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void signUp(UserForm userForm) {
        if(!usersRepository.findOneByLogin(userForm.getLogin()).isPresent()) {
            String hashPassword = passwordEncoder.encode(userForm.getPassword());

            User user = User.builder()
                    .hashPassword(hashPassword)
                    .login(userForm.getLogin())
                    .build();

            usersRepository.save(user);
        } else throw new IllegalArgumentException("Login already used");
    }
}
